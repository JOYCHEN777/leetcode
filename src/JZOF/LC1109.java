package JZOF;

public class LC1109 {
    /*这里有n个航班，它们分别从 1 到 n 进行编号。
我们这儿有一份航班预订表，表中第i条预订记录bookings[i] = [j, k, l]意味着我们在从 j到 k的每个航班上预订了 l个座位。
请你返回一个长度为 n 的数组answer，按航班编号顺序返回每个航班上预订的座位数。
    * */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                answer[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ans = corpFlightBookings(bookings, n);
        for (int a : ans) {
            System.out.println(a);
        }
        //System.out.println(Math.abs('b'-'b'));
    }
}
