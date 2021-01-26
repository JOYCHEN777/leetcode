package JZOF;

/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ13 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1){
            return ;
        }
        int[] arr=new int[array.length];
        int odd=0;
        int even=array.length-1;
        for(int i=0; i<array.length; i++){
            if((array[i]%2) != 0){
                arr[odd]=array[i];
                odd++;
            }
        }
        for(int j= array.length-1; j>=0 ;j--){
            if((array[j]%2) == 0){
                arr[even]=array[j];
                        even--;
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=arr[i];
        }


    }
}
