package JZOF;

/**
 * 一般在代码Code Review或者持续集成过程中，
 * 一次代码提交会触发代码的重新编译及正在Review过程的Pull Request的Approval重置，
 * 为了加快编译或者只重置受影响的Pull Reqeust，
 * 都会进行代码包依赖分析，找出受影响的代码包(package)。
 * 我们使用正整数表示包，对给定的被修改的包，求出所有受影响的包(去重)所代表数字的和，
 * 若无受影响的包，则和返回-1。注意，直接依赖及间接依赖的包被修改，当前包均被定义为受影响。
 */


/**
 * 第一行为整数，代表被修改的包。
 * 第二行开始的后续行都是数组，代表数组的第一个元素依赖后续的元素，
 * 注意数组元素可能只有1个，代表该包无依赖。
 * 如输入样例的含义为被修改的包是4，包1依赖2, 包3依赖4、5、6,  包2依赖3,  包6依赖4、2, 包8依赖9，包10无依赖。
 * 4
 * 1,2
 * 3,4,5,6
 * 2,3
 * 6,4,2
 * 8,9
 * 10
 * 输出：所有受影响的包去重后为1、2、3、6，所以其和为12.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class XC2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int affected = in.nextInt();
        in.nextLine();
        HashMap<Integer, int[]> map = new HashMap<>();
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(",");
            int k = Integer.parseInt(line[0]);
            int[] v = new int[line.length - 1];
            for (int i = 0; i < v.length; i++) {
                v[i] = Integer.parseInt(line[i + 1]);
            }
            map.put(k, v);
        }
        System.out.println(func(map, affected));
    }

    public static int func(HashMap<Integer, int[]> map, int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        for (int obj : set) {
            for (int k : map.keySet()) {
                int[] v = map.get(k);
                for (int i = 0; i < v.length; i++) {
                    if (v[i] ==obj) {
                        set .add(k);
                    }

                }
            }
        }
        int res=0;
        for(int i:set){
            res+=i;
        }
        return res-n;

    }
}
