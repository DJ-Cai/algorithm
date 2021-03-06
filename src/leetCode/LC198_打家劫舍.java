package leetCode;

public class LC198_打家劫舍 {
	
//	198. 打家劫舍
//	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//	给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//	示例 1：
//	输入：[1,2,3,1]
//	输出：4
//	解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//	     偷窃到的最高金额 = 1 + 3 = 4 。
	
	public static void main(String[] args) {
		int res = rob(new int[] {1,2,3,1});
		System.out.println(res);
	}
	
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        //定义：当前房子下，能打劫到的最高金额（可能不包含当前房子）
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < res.length ; i ++){
        	//状态转移：打劫当前房子，则不能打劫前一间，所以是当前房子金额+上上间总金额；
        	//		 不打劫当前房子，则是上一间的总金额
            res[i] = Math.max(res[i-2] + nums[i] , res[i-1]);
        }
        return res[res.length -1];

        //压缩
        // if(nums == null || nums.length == 0){
        //     return 0;
        // }
        // int cur = nums[0];
        // int pre = 0;
        // for(int i = 1 ; i < nums.length ; i++){
        //     int temp = Math.max(cur , pre + nums[i]);
        //     pre = cur;
        //     cur = temp;
        // }
        // return cur;
    }
}
