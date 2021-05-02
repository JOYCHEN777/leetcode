package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparaTest {
    public static void main(String[] args) {
        List<int[]> arr=new ArrayList<>();
        arr.add(new int[]{1,1});
        arr.add(new int[]{3,2});
        arr.add(new int[]{2,3});
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];//倒序
            }
        });
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i)[1]);
        }

    }
}
