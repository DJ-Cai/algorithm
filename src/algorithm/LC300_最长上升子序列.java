package algorithm;

import java.util.Arrays;

public class LC300_最长上升子序列 {
	/**
	 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

		示例:
		
		输入: [10,9,2,5,3,7,101,18]
		输出: 4 
		解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
		说明:
		
		可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
		你算法的时间复杂度应该为 O(n2) 。

	 *  PS:用二分搜索还可以将复杂度降低到O（nlogn），这里不追究了
	 */
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}
	
	
	public static  int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //结果集：从前直到包含这个元素的最长上升子序列长度
        int[] res = new int[nums.length];

        //初始化，元素的最长上升子序列肯定包含自己
        //写到这里理所当然的想到需要处理特殊情况---最前面
        Arrays.fill(res,1);

        //开始做判断：当前元素的最长上升子序列长度为多少
        //PS：子序列与子数组、子串不同，子序列不要求连续
        //判断方法：找到前面的小于自己的 最大res值+1 和 自己值进行比较即可
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    res[i] = Math.max(res[j] + 1 , res[i]);
                }
            }
        }

        //最后需要遍历res，得到最大值
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < res.length ;i++){
            max = Math.max(max,res[i]);
        }
        return max;
    }
}
