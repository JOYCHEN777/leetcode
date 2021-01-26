package JZOF;

public class LC42 {
    public static int trap(int[] height) {
        int i = 0;
        int res = 0;

        while (i < (height.length - 1)) {
            int start = -1;
            int end = -1;
            if (height[i] >= height[i + 1]) {
                start = i;
                i++;
                while (i < height.length - 1) {
                    if (height[i] <= height[i + 1]) {
                        end = i + 1;
                        i++;
                    } else if (end > 0) {
                        if (height[end] < height[start]) {
                            for (int t = i; t < height.length; t++) {
                                if (height[t] >= height[end]) {
                                    end = t;
                                    i = t;
                                }
                                if(height[end]>=height[start]){
                                    break;//5
                                }
                            }
                            break;//1
                        } else {
                            break;//2
                        }
                    } else {
                        i++;//3
                    }
                }
            } else {
                i++;//4
            }
            if (start >= 0 && end >= 0) {
                int level = Math.min(height[start], height[end]);
                for (int j = start; j <= end; j++) {
                    if (level - height[j] >= 0) {
                        res += (level - height[j]);
                        System.out.print("start:"+start+" "+"end:"+end+" " +"res:"+res+"\n");
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        int res = trap(height);
        System.out.print(res);

    }
}

