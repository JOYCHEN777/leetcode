package JZOF;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 */
public class LC1723 {


    public static void main(String[] args) {
        String[] s=new String[4];
        s[0]="3";
        s[1]="312";
        s[2]="43";
        s[3]="13";

        Arrays.sort(s,(o1, o2) -> (int) (Long.parseLong(o1+o2)- Long.parseLong(o2+o1)));
        for(int i=0;i<4;i++){
            System.out.println( s[i]);
        }

    }
}
