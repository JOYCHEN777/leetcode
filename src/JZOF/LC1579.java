package JZOF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1579 {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        int res = 0;
        Set<int[]> resList = new HashSet<>();
        /*Set<Integer> allEdges=new HashSet<>();
        for(int i=0;i<=edges.length-1;i++){
            allEdges.add(edges[i][1]);
            allEdges.add(edges[i][2]);
        }*/
        List<int[]> edges1 = category(edges, 1);
        List<int[]> edges2 = category(edges, 2);
        List<int[]> edges3 = category(edges, 3);
        Set<Integer> aliceEdges = new HashSet<>();
        for (int i = 0; i <= edges1.size() - 1; i++) {
            aliceEdges.add(edges1.get(i)[1]);
            aliceEdges.add(edges1.get(i)[2]);
        }
        Set<Integer> bobEdges = new HashSet<>();
        for (int i = 0; i <= edges2.size() - 1; i++) {
            bobEdges.add(edges2.get(i)[1]);
            bobEdges.add(edges2.get(i)[2]);
        }
        for (int i = 0; i <= edges3.size() - 1; i++) {
            aliceEdges.add(edges3.get(i)[1]);
            aliceEdges.add(edges3.get(i)[2]);
            bobEdges.add(edges3.get(i)[1]);
            bobEdges.add(edges3.get(i)[2]);
        }
        if (aliceEdges.size() != n || bobEdges.size() != n) {
            return -1;
        }
        //分别判断alice和bob他们有没有多余的连线，先加3类型的连线
        //alice
        UF uf1 = new UF(n);
        UF uf2 = new UF(n);
        for (int i = 0; i <=edges3.size() - 1; i++) {
            int x = edges3.get(i)[1];
            int y = edges3.get(i)[2];
            boolean a=uf1.union(x, y);
            boolean b=uf2.union(x, y);
            if (!a) {
                res++;
            }
        }
        for (int i = 0; i <=edges1.size() - 1; i++) {
            int x = edges1.get(i)[1];
            int y = edges1.get(i)[2];
            if (uf1.union(x, y)==false) {
                res++;
            }
        }
        for (int i = 0; i <= edges2.size() - 1; i++) {
            int x = edges2.get(i)[1];
            int y = edges2.get(i)[2];
            if (uf2.union(x, y)==false) {
                res++;
            }
        }

        return res;
    }

    //把节点根据类型先做个分类。
    public static List<int[]> category(int[][] arr, int n) {
        int size = arr.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i <= size - 1; i++) {
            if (arr[i][0] == n) {
                res.add(arr[i]);
            }
        }
        return res;
    }
}

class UF {
    int n;
    int[] parent;
    int[] rank;

    public UF(int n) {
        this.n = n;
        this.parent = new int[n + 1];
        this.rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int x) {
        int xR = x;
        while (xR != parent[xR]) {
            parent[xR] = parent[parent[xR]];
            xR = parent[xR];
        }
        return xR;
    }

    public boolean union(int x, int y) {
        int xr = findRoot(x);
        int yr = findRoot(y);
        if (xr == yr) {
            return false;
        } else {
            if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else {
                parent[xr] = yr;
                rank[yr]++;
            }
        }
        return true;
    }
}
