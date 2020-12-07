package algorithm;

public class No518_Change {
	//零钱兑换Ⅱ：给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
	//	输入: amount = 5, coins = [1, 2, 5]
	//			输出: 4
	//			解释: 有四种方式可以凑成总金额:
	//			5=5
	//			5=2+2+1
	//			5=2+1+1+1
	//			5=1+1+1+1+1
	public static void main(String[] args) {
		change(5,new int[] {1,2,5});
	}
	
	public static int change(int amount, int[] coins) {
        if(amount == 0 || coins == null || coins.length == 0){
            return 0;
        }
        int[] res = new int[amount + 1];
        res[0] = 1;

        //首先它是个动态规划--总方案数可以用前面的amout-count[x]（x：不同的硬币）的几个之和算出来
         for (int coin : coins) {
             for (int x = coin; x < amount + 1; ++x) {
                 res[x] += res[x - coin];
             }
         }
         
        return res[amount];
    }
}
