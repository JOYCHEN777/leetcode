package JZOF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC1631 {
    /*你准备参加一场远足活动。给你一个二维rows x columns的地图heights，其中heights[row][col]表示格子(row, col)的高度。
    一开始你在最左上角的格子(0, 0)，且你希望去最右下角的格子(rows-1, columns-1)（注意下标从 0 开始编号）。
    你每次可以往 上，下，左，右四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
    一条路径耗费的 体力值是路径上相邻格子之间 高度差绝对值的 最大值决定的。
    请你返回从左上角走到右下角的最小体力消耗值
*/
    public int minimumEffortPath(int[][] heights) {
        int res=0;
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (j + 1 < n) {
                    edges.add(new int[]{id, id + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
                if (i + 1 < m) {
                    edges.add(new int[]{id, id + n, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        UnionFindSwim ufs = new UnionFindSwim(m * n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int h = edge[2];
           ufs.union(x,y);
           if(ufs.connected()){
               res=h;
               break;
           }
        }
        return res;
    }
}

class UnionFindSwim {
    int[] parent;
    int[] rank;
    int n;
    int count;

    public UnionFindSwim(int n) {
        this.count = n;
        this.parent = new int[n];
        this.rank = new int[n];
        this.n=n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    public int findRoot(int x) {
        int xRoot = x;
        while (xRoot != parent[xRoot]) {
            parent[xRoot] = parent[parent[xRoot]];
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    public boolean connected() {
        int x=findRoot(0);
        int y=findRoot(n-1);
        return x==y;
    }

    public boolean union(int x, int y) {
        int xr = findRoot(x);
        int yr = findRoot(y);
        if (xr == yr) {
            return false;
        } else {
            if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
                count--;
            }
            if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
                count--;
            }
            if (rank[xr] == rank[yr]) {
                parent[xr] = yr;
                rank[yr]++;
                count--;
            }
        }
        return true;
    }
}
