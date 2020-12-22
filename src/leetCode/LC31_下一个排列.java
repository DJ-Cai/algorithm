package leetCode;

public class LC31_下一个排列 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,5};
		nextPermutation(arr);
		for(int i : arr) {
			System.out.print(i + "   ");
		}
	}
	
	
    //思路：找两个数：1、左边的小数，要尽量右边 2、右边的大数，要尽量小  
    //交换以后，升序排列小数后的元素
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return ;   
        }
        //要小数尽量右，就从右边往左找起,第一个小于右边元素的
        int smallNum = 0;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                smallNum = i;
                break;
            }
        }
        //要大数尽量小，就从右往左找，第一个大于小数的，就比较小了
        int bigNum = smallNum;
        for(int i = nums.length - 1 ; i > smallNum ; i--){
            if(nums[i] > nums[smallNum]){
                bigNum = i;
                break;
            }
        }
        //如果没找到大数，证明小数最大，进而证明找小数的for循环是失败的，smallNum = 0 且为最大值。
        //所以整个数组都是降序的，直接排序就好。
        if(smallNum == bigNum){
            sort(nums,smallNum);
            return ;
        }
        //交换
        swap(nums,smallNum,bigNum);
        //升序排列在小数后的元素(细节：交换后 排序在小数后的元素其实是降序的，具体分析一下找小数和大数的过程就好了)
        sort(nums,smallNum+1);
    }

    public static void swap(int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums, int index ){
        //可以看作是要反转降序数组至升序
        int last = nums.length - 1;
        while(index < last){
            swap(nums,index++,last--);
        }
    }
}
