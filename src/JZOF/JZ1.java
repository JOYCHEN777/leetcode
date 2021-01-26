package JZOF;

public class JZ1 {
    /*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
    。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/
    public static int binSearch(int[] array, int target) {
        int front = 0, last = array.length - 1;
        while (front < last) {
            int mid = (front + last) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                last = mid;
            } else if (array[mid] < target) {
                front = mid++;
            }
        }
        return -1;
    }

    public static boolean Find(int target, int[][] array) {
        int lineFront = 0, lineLast = array[0].length;
        int rowFront = 0, roeLast = array.length;
        while (lineFront < lineLast) {

        }
        return true;
    }

    public static void main(String[] args) {
        int res = JZ1.binSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.print(res);
    }
}
