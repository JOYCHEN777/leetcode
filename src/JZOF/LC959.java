package JZOF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC959 {
    /*在由 1 x 1 方格组成的 N x N 网格grid 中，每个 1 x 1方块由 /、\ 或空格构成。
    这些字符会将方块划分为一些共边的区域。请注意，反斜杠字符是转义的，因此 \ 用 "\\"表示。）。
    返回区域的数目。
。*/
    public static int regionsBySlashes(String[] grid){
        int res=0;
        int len= grid.length;
        //把grid转化成图的节点，先把边填进去
        List<int[]> edges=new ArrayList<>();
        for(int i=1;i<=len;i++){
            int[] edge1=new int[]{i,i+1};
            edges.add(edge1);
            int[] edge2=new int[]{len*(len+1)+i,len*(len+1)+i+1};
            edges.add(edge2);
        }
        for(int i=1;i<=len;i++){
            int[] edge1=new int[]{1+(i-1)*(len+1),1+i*(len+1)};
            edges.add(edge1);
            int[] edge2=new int[]{i*(len+1),(i+1)*(len+1)};
            edges.add(edge2);
        }
        //填grid内部的点，要先转化
        for(int i=1;i<=len;i++){
            //int index=0;
            //每行
            for(int j=1;j<=len;j++){
                if(grid[i-1].charAt(j-1)=='/'){
                    int[] edge=new int[]{(i-1)*(len+1)+j+1,i*(len+1)+j};
                    edges.add(edge);
                }
                if(grid[i-1].charAt(j-1)=='\\'){
                    int[] edge=new int[]{(i-1)*(len+1)+j,i*(len+1)+j+1};
                    edges.add(edge);
                }

            }
        }
        //这时得到了edges是所有连线，接下来用并查集看有几个环就是分割成了几块
        int n=(len+1)*(len+1);
        UnionFindGrid ufg=new UnionFindGrid(n);
        for(int i=0;i<=edges.size()-1;i++){
            GridEdge edge=new GridEdge(edges.get(i));
            int x=edge.x;
            int y=edge.y;
            if(!ufg.union(x,y)){
                res++;
            }
        }
        return res;
    }
}
class GridEdge{
    int x,y;
    public GridEdge(int[] edge) {
        this.x=edge[0];
        this.y=edge[1];
    }
}
class UnionFindGrid{
    int[] parent;
    int[] rank;
    int n;
    public UnionFindGrid(int n){
        this.n=n;
        this.rank=new int[n+1];
        Arrays.fill(rank,1);
        this.parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
    }
    public int findRoot(int x){
        int root=x;
        while(parent[root]!=root){
            root=parent[root];
        }
        return root;
    }
    public boolean union(int x,int y){
        int xRoot=findRoot(x);
        int yRoot=findRoot(y);
        if(xRoot==yRoot){
            return false;
        }
        if(rank[y]>rank[x]){
            rank[yRoot]+=rank[xRoot];
            parent[xRoot]=yRoot;
        }else{
            rank[xRoot]+=rank[yRoot];
            parent[yRoot]=xRoot;
        }
        return true;
    }
}
