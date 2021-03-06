package leetCode;

import java.util.Arrays;

public class LC213_打家劫舍Ⅱ {
//	
//	213. 打家劫舍 II
//	你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//	给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
//	示例 1：
//	输入：nums = [2,3,2]
//	输出：3
//	解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//	
//	示例 2：
//	输入：nums = [1,2,3,1]
//	输出：4
//	解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//	     偷窃到的最高金额 = 1 + 3 = 4 。
	
	public static void main(String[] args) {
		int res = rob(new int[] {2,3,2});
		System.out.println(res);
	}
	
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        //解环：环状只增加了一个限制条件：打劫第一间，则最后一间不可打劫，打劫最后一间，则第一间不可打劫
        return Math.max(
                            process(Arrays.copyOfRange(nums,1,nums.length)) , 
                            process(Arrays.copyOfRange(nums,0,nums.length - 1))
                        );

    }

    public static int process(int[] nums){
         if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = nums[0];
        int pre = 0;
        for(int i = 1 ; i < nums.length ; i++){
            int temp = Math.max(cur , pre + nums[i]);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
