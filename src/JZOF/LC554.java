package JZOF;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 * 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
 * 你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 */

public class LC554 {
    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(List<Integer> list:wall){
            int sum=0;
            for(int i=0;i<list.size()-1;i++){
                sum+=list.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int max=0;
        for(int i:map.keySet()){
            max=Math.max(max,map.get(i));
        }
        return wall.size()-max;


    }
    public static void main(String[] args) {

    }

}
