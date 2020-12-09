package 剑指Offer;

public class O42_连续子数组最大和 {
	/**
	 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
		要求时间复杂度为O(n)。
		示例1:
		输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
		输出: 6
		解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            //记录最大值
            max = Math.max(sum , max);
            //和小于零 则重新开始
            sum = sum > 0 ? sum : 0;
        }
        return max;
    }
}
