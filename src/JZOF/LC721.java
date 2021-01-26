package JZOF;

import java.util.*;

public class LC721 {
    /*给定一个列表 accounts，每个元素 accounts[i]是一个字符串列表，其中第一个元素 accounts[i][0]是名称 (name)，
    其余元素是 emails 表示该账户的邮箱地址。现在，我们想合并这些账户。
    如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
    请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
    一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
    合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
*/
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        //use map to represent email
        Map<String,Integer> emailToIndex=new HashMap<>();
        Map<String,String> emailToName=new HashMap<>();
        int count=0;
        for(List<String> account : accounts){
            String name=account.get(0);
            for(int i=1;i<=account.size()-1;i++){
                String email=account.get(i);
                if(!emailToIndex.containsKey(email)){
                    emailToIndex.put(email,count++);
                    emailToName.put(email,name);
                }
            }
        }
        //new a parent
        int[] parent=new int[count+1];
        initializeParent(parent);

        for(List<String> account: accounts){
            String firstEmail=account.get(1);
            int key1=emailToIndex.get(firstEmail);
            for(int i=2;i<=account.size()-1;i++){
                String secondEmail=account.get(i);
                int key2=emailToIndex.get(secondEmail);
                union(key1,key2,parent);
            }
        }
        Map<Integer,List<String>> indexToEmail=new HashMap<>();
        for(String email:emailToIndex.keySet()){
            int index=find(parent,emailToIndex.get(email));
            List<String> account=indexToEmail.getOrDefault(index,new ArrayList<>());
            account.add(email);
            indexToEmail.put(index,account);
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> emails:indexToEmail.values()){
            Collections.sort(emails);
            String name=emailToName.get(emails.get(0));
            List<String> account=new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }

    public static int find(int[] parent, int x) {
        int xRoot = x;
        while (parent[xRoot] != xRoot) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    public static void union(int x, int y, int[] parent) {
        int xr = find(parent, x);
        int yr = find(parent, y);
        parent[xr] = yr;
    }

    public static void initializeParent(int[] parent){
        for (int i=0;i<=parent.length-1;i++){
            parent[i]=i;
        }
    }

    public static void main(String[] args){
        List<List<String>> ac= new ArrayList<>();
        ac.add(Arrays.asList("j","a@qq.com","b@qq.com"));
        ac.add(Arrays.asList("j","a@qq.com","c@qq.com"));
        List<List<String>> o= accountsMerge(ac);

    }
}
