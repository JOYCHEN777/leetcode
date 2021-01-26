package JZOF;

public class LCEveryDay {
    /*
    684. 冗余连接
    在本问题中, 树指的是一个连通且无环的无向图。
    输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
    附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
    结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
    返回一条可以删去的边，使得结果图是一个有着N个节点的树。
    如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
    */
    public static int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int[] parent = new int[1001];
        initialize(-1, parent);
        for (int i = 0; i <= edges.length - 1; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            boolean mark = unionVertices(x, y, parent);
            if (mark == false) {
                res[0] = x;
                res[1] = y;
                break;
            }
        }
        return res;
    }

    public static int findRoot(int x, int[] parent) {
        int xRoot = x;
        while (parent[xRoot] != -1) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    public static boolean unionVertices(int x, int y, int[] parent) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if (xRoot == yRoot) {
            return false;
        } else {
            parent[xRoot] = yRoot;
            return true;
        }
    }

    public static void initialize(int x, int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = x;
        }
    }
    /* 947. 移除最多的同行或同列石头
    n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
    如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
    给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
    */
    public static int removeStones(int[][] stones){
        int res=0;
        int[] parent=new int[20001];
        initialize(-1,parent);
        for(int i=0;i<=stones.length-1;i++){
            int x=stones[i][0];
            int y=stones[i][1]+1000;
            boolean mark=unionVertices(x,y,parent);
            if(mark){
                res++;
            }
        }
        return res;
    }


    public static int fRoot(int x,int[] parent) {
        int xr=x;
        while(parent[x]!=-1){
            xr=parent[xr];
        }
        return xr;
    }
    public static void main(String[] args){
        int[][] in = {{1,2},{1,3},{2,3}};
        int[] res=findRedundantConnection(in);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }


}
