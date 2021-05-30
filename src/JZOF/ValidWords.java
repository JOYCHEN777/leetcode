package JZOF;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ValidWords {
    private static String articlePath = "/Users/joycyan/Desktop/CMT219/cw2/src/an_article.txt";
    private static String dictPath = "/Users/joycyan/Desktop/CMT219/cw2/src/google-10000-english-no-swears.txt";

    public static void main(String[] args) throws IOException {
        int res = 0;
        for (String s : extract()) {
            res++;
            System.out.print(s+" ");
        }
        System.out.println(res);
    }

    public static ArrayList<String> extract() throws IOException {
        /*
         * add word in google.txt to a set
         * we can use set.contains() to justify whether a word is valid
         */
        HashSet<String> dict = new HashSet<>();
        FileInputStream fin1 = new FileInputStream(dictPath);
        InputStreamReader isr1 = new InputStreamReader(fin1);
        BufferedReader br1 = new BufferedReader(isr1);
        String s = "";
        while ((s = br1.readLine()) != null) {
            dict.add(s.trim());
        }
        br1.close();
        /*
         * read the article by stream and then use BufferReader to read it by line.
         * split the line by space to get single word. Then use check() to deal with word in low/upCase and punctuation thing.
         * */
        ArrayList<String> res = new ArrayList<>();
        FileInputStream fin2 = new FileInputStream(articlePath);
        InputStreamReader isr2 = new InputStreamReader(fin2);
        BufferedReader br2 = new BufferedReader(isr2);
        String line = "";
        while ((line = br2.readLine()) != null) {
            String[] str = line.trim().split("\\s+");
            for (String word : str) {
                String ans = check(word);
                if (dict.contains(ans)) {
                    res.add(ans);
                }
            }
        }
        br2.close();
        return res;
    }

    /**
     * This function is to handling punctuation
     *
     * @param s the word may have punctuation
     * @return return a new string which is the word without punctuation or a "!";
     */
    public static String check(String s) {
        /*
         *first step ,return "!" .so that we don't have to consider some out of index things and nullPointException
         */
        if (s == null || s.length() < 1) {
            return "!";
        }
        s = s.trim().toLowerCase();
        char begin = s.charAt(0);
        char end = s.charAt(s.length() - 1);
        if (begin - 'a' < 0 || begin - 'z' > 0) {
            if (s.length() <= 1) {
                return "!";
            }
            s = s.substring(1, s.length() - 1);
        }
        if (end - 'a' < 0 || end - 'z' > 0) {
            if (s.length() <= 1) {
                return "!";
            }
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
