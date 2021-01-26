package JZOF;

public class LC1710 {
    public  static int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        if (boxTypes == null || boxTypes.length == 0 || truckSize == 0) {
            return res;
        }
        if (boxTypes.length == 1) {
            res = (Math.min(boxTypes[0][0], truckSize)) * boxTypes[0][1];
            return res;
        }

        int x;
        int y;
        for (int i = 0; i <= boxTypes.length - 1; i++) {
            for (int j = i + 1; j <= boxTypes.length - 1; j++) {
                if (boxTypes[i][1] < boxTypes[j][1]) {
                    x = boxTypes[i][1];
                    boxTypes[i][1] = boxTypes[j][1];
                    boxTypes[j][1] = x;
                    y=boxTypes[i][0];
                    boxTypes[i][0] = boxTypes[j][0];
                    boxTypes[j][0] = y;
                }
            }

        }

        int p = truckSize;
        int i = 0;
        while (p > 0 && i <= boxTypes.length - 1) {
            res += (Math.min(boxTypes[i][0], p)) * boxTypes[i][1];
            p = p - boxTypes[i][0];
            i++;

        }
        return res;
    }
    public static void main(String[] args){
        int[][] bt={{5,10},{2,5},{4,7},{3,9}};
        int ts = 10;
        System.out.print(maximumUnits(bt,ts));
    }

}

