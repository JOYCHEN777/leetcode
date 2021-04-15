package JZOF;
/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * 请你实现ParkingSystem类：
 * ParkingSystem(int big, int medium, int small)初始化ParkingSystem类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType)检查是否有carType对应的停车位。
 * carType有三种类型：大，中，小，分别用数字1，2和3表示。一辆车只能停在carType对应尺寸的停车位中。
 * 如果没有空车位，请返回false，否则将该车停入车位并返回true。
 */
public class ParkingSystem {
    int[] mark=new int[3];
    public ParkingSystem(int big, int medium, int small) {
        mark[0]=big;
        mark[1]=medium;
        mark[2]=small;

    }

    public boolean addCar(int carType) {
        if(mark[carType-1]<1){
            return false;
        }else{
            mark[carType-1]--;
        }
        return true;
    }
}
