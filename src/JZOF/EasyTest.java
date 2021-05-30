package JZOF;

import java.sql.SQLOutput;
import java.util.*;

final public class EasyTest {
    public static void main(String[] args) {
        int[] nums=new int[]{2,2};
        System.out.println(search(nums,2));
        }
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length<1||target<nums[0]||target>nums[nums.length-1]){
            return 0;
        }

        int l=0;
        int r=nums.length;
        int res=0;
        int m=-1;
        while(l<r){
            m=l+(r-l)/2;
            if(target<nums[m]){
                r=m;
            }else if(target>nums[m]){
                l=m+1;
            }else{
                l=m;
                res+=1;
                break;
            }
        }
        l=m-1;
        r=m+1;
        while(l>0&&nums[l]==target){
            res++;
            l--;
        }
        while(r<nums.length&&nums[r]==target){
            res++;
            r++;
        }
        return res;
    }

    public static List<Integer> decrease(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 0) {
            return res;
        }
        int l = 0;
        int r = 1;
        int max = 1;
        while (l < arr.length && l < r) {
            List<Integer> ans = new ArrayList<>();
            ans.add(arr[l]);
            while (r < arr.length && arr[r] <= arr[r - 1]) {
                ans.add(arr[r]);
                r++;
            }
            if (ans.size() > max) {
                max = ans.size();
                res = ans;
            }
            l = r;
            r++;
        }
        return res;
    }

    public static List<Integer> isPrime(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(2);
        boolean[] mark = new boolean[n + 1];//false
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (!mark[i]) {//是素数
                int t = i;
                while (i * t <= n) {
                    mark[i * t] = true;
                    t++;
                }
            }

        }
        for (int i = 3; i < n + 1; i += 2) {
            if (!mark[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean judgeSquareSum(int c) {
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;
        dp[1] = true;
        for (int i = 2; i < c + 1; i++) {
            if (Math.sqrt(c) == (int) Math.sqrt(c)) {
                dp[i] = true;
            } else {
                dp[i] = false;
                for (int j = 0; j * j < i; j++) {
                    if (dp[i - j * j] == true) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[c];


    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (k >= nums.length) {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int v = map.get(nums[i]) + 1;
                map.put(nums[i], v);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});

        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        int[] test = map.entrySet().stream().sorted((m1, m2) -> m2.getValue() - m1.getValue()).limit(k).mapToInt(Map.Entry::getKey).toArray();
        return test;


    }

    public static TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();

        LinkedList<TreeNode> res = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            res.add(stk.pop());
            root = stk.peek();
            root = root.right;
        }
        root = res.poll();
        root.left = null;
        root.right = null;
        TreeNode p = root;
        while (!res.isEmpty()) {
            p.right = res.poll();
            p = p.right;
            p.right = null;
            p.left = null;
        }
        return root;
    }

    public static char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char t = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == t) {
                    arr[i] = 'A';
                    arr[j] = 'A';
                }
            }
        }
        char res = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'A') {
                res = arr[i];
                return res;
            }
        }
        return res;

    }

    public static int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) >= nums.length / 2) {
                    return nums[i];
                }
                int v = map.get(nums[i]);
                map.put(nums[i], v + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return 1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int l = que.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer((node.right));
                }
            }
            res.add(temp);
        }

        return res;
    }
}