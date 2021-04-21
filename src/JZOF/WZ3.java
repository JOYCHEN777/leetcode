package JZOF;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 这些操作将分别以如下形式给出：
 * Change s x y : 将建筑s修改到位置(x, y)上，不保证该建筑一定存在，对于不存在的建筑不进行操作。
 * Delete s : 拆除建筑s，不保证该建筑一定存在。对于不存在的建筑忽略即可。
 * Add s x y : 在(x, y)这个位置上修建建筑s，保证不出现重名建筑同时存在的情况，但完全有可能重新建立之前删掉的建筑。
 * 作为统筹地图修改工作的负责人，每天都有很多人来问你问题。对于每个询问，你都要如实地告诉他他所问的建筑现在是否存在，
 * 如果存在的话，应该到哪里找到它。
 * 每个询问将以这样的形式给出
 * Query s : 询问建筑s的相关情况。你需要先给出一行yes或no表明是否有该栋建筑，若有则需要继续给出一行(x, y) 表示其位置
 * 注意：同一个地方完全可以存在多个建筑，因此多个建筑位于同一个坐标下是合法的。
 * Add Gymnasium 232 111
 * Add Park 23 125
 * Query Gymnasium
 * Change PizzaHut 222 123
 * Query PizzaHut
 * Delete PizzaHut
 * Query PizzaHut
 */
public class WZ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] str = s.split(" ");
            if (str[0].equals("Add")||str[0].equals("Change")) {
                add(map, str);
            } else if (str[0].equals("Delete")) {
                delete(map,str);
            }else if(str[0].equals("Query")){
                boolean res=query(map,str);
                if(res){

                    System.out.println("yes");
                    System.out.print(map.get(str[1])[0]);
                    System.out.print(" ");
                    System.out.print(map.get(str[1])[1]);
                    System.out.println();
                }else{
                    System.out.println("no");
                }
            }
        }
    }

    public static void add(HashMap<String, int[]> map, String[] str) {
        String name = str[1];
        int x = Integer.parseInt(str[2]);
        int y = Integer.parseInt(str[3]);
        int[] v = new int[]{x, y};
        map.put(name, v);
    }

    public static void delete(HashMap<String, int[]> map, String[] str) {
        String name = str[1];
        map.remove(name);
    }

    public static boolean query(HashMap<String, int[]> map, String[] str) {
        String name = str[1];
        return map.containsKey(name);
    }


}

