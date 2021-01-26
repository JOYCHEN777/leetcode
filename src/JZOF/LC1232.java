package JZOF;

public class LC1232 {
    /*在一个XY 坐标系中有一些点，
    我们用数组coordinates来分别记录它们的坐标，
    其中coordinates[i] = [x, y]表示横坐标为 x、纵坐标为 y的点。
    请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
*/
    public static boolean checkStraightLine(int[][] coordinates) {
        boolean res = true;
        float a;
        float b;
        if (coordinates.length <= 2) {
            return res;
        }
        if ((coordinates[1][0] - coordinates[0][0]) != 0) {
            a = ((float)(coordinates[1][1] - coordinates[0][1])/ (float)(coordinates[1][0] - coordinates[0][0]));
            b = (float) coordinates[0][1] - a * coordinates[0][0];
            for (int i = 2; i <= coordinates.length - 1; i++) {
                if ((float) coordinates[i][1] != a * coordinates[i][0] + b) {
                    res = false;

                }
            }
        } else {
            for (int i = 2; i <= coordinates.length - 1; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    res = false;
                }
            }

        }
        return res;
    }
    public static void main(String[] args){
        int[][] para={{2,1},{4,2},{6,3}};
        System.out.println(checkStraightLine(para));
    }
}
