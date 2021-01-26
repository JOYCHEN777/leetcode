package JZOF;

import java.util.*;

public class LC1584 {
    /*给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。
连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：|xi - xj| + |yi - yj|，其中|val|表示val的绝对值。
请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，才认为所有点都已连接。
     */
    public static int minCostConnectPoints(int[][] points){
        int n=points.length;
        List<Edge> edges=new ArrayList<>();
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<=n-1;i++){
            for(int j=i+1;j<=n-1;j++){
                int len=Math.abs(points[i][0]-points[j][0])+ Math.abs(points[i][1]-points[j][1]);
                edges.add(new Edge(len,i,j));
            }
        }
        Collections.sort(edges,((o1, o2) -> o1.len-o2.len));
        int ans=0, num=1;
        for(Edge edge:edges){
            int len=edge.len;
            int x=edge.x;
            int y=edge.y;
            if(uf.union(x,y)){
                ans += len;
                num++;
                if(num==n){
                    break;
                }
            }
        }
        return ans;

    }


}
class Edge{
    int len,x,y;
    public Edge(int len,int x,int y){
        this.len=len;
        this.x=x;
        this.y=y;
    }
}
class UnionFind{
    int[] parent;
    int[] size;
    int n;
    public UnionFind(int n){
        this.n=n;
        this.size=new int[n];
        Arrays.fill(this.size,1);
        this.parent=new int[n];
        for(int i=1;i<=n-1;i++){
            this.parent[i]=i;
        }
    }
    public int findRoot(int x){
        int xRoot=x;
        while(parent[xRoot]!=x){
            xRoot=parent[xRoot];
        }
        return xRoot;
    }
    public boolean union(int x,int y){
        int xRoot=findRoot(x);
        int yRoot=findRoot(y);
        if(xRoot==yRoot){
            return false;
        }
        if(size[x]>size[y]){
            parent[yRoot]=xRoot;
            size[xRoot]=size[xRoot]+size[yRoot];
        }else{
            parent[xRoot]=yRoot;
            size[yRoot]+=size[xRoot];
        }
        return true;
    }
}
