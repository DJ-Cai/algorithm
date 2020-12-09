package leetCode;

import java.util.Arrays;

public class LC322_零钱兑换 {
	/**
	 * 给定不同面额的硬�? coins 和一个�?�金�? amount。编写一个函数来计算可以凑成总金额所�?的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1�?

		你可以认为每种硬币的数量是无限的�?
		示例 1�?
		输入：coins = [1, 2, 5], amount = 11
		输出�?3 
		解释�?11 = 5 + 5 + 1
		
		示例 2�?
		输入：coins = [2], amount = 3
		输出�?-1
	 */
	public static void main(String[] args) {
		//System.out.println();
		coinChange( new int[] {1,2,5} ,11);
	}
	
	
    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0){
            return 0;
        }

        //�?少个数可以�?�过 “amount - coin 的最少个�? + 1”获�?----化解为子问题
        int[] res = new int[amount + 1];

        //对数组进行初始化，因为是�?少，�?以初始化尽量大，则一般会选取Integer.MAX_VALUE
        //但题目要求无结果返回-1 . 后面会出现一些边界判断比较麻烦，这里选取不可能达到的数即可，例如amount + 1 （硬币都是整数的情况下，�?少个数不可能超过amount本身，现实情况的角分硬币另说，同理）
        Arrays.fill(res , amount + 1);
        //amount = 0 时，不需要硬�?
        res[0] = 0;
        
        //�?始遍�?
        for(int i = 1 ; i < res.length ; i++){
            for(int j = 0 ; j < coins.length ;j++){
                if(i - coins[j] >= 0){
                    res[i] = Math.min(res[i] , res[i - coins[j]]+ 1);
                }
            }
        }
        return res[res.length - 1] == amount + 1 ? -1 : res[res.length - 1];
    }
}
