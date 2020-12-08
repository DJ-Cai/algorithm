package algorithm;

public class No518_零钱兑换 {
	/**
	 * 零钱兑换Ⅱ：给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
		输入: amount = 5, coins = [1, 2, 5]
				输出: 4
				解释: 有四种方式可以凑成总金额:
				5=5
				5=2+2+1
				5=2+1+1+1
				5=1+1+1+1+1
	 */
	
	public static void main(String[] args) {
		System.out.println(change(5,new int[] {1,2,5}));
	}
	
	public static int change(int amount, int[] coins) {
	    if(amount == 0 || coins == null || coins.length == 0){
	        return 0;
	    }
	    //分别计算出小于指定amount的值的结果
	    int[] res = new int[amount + 1];
	    //res[0]其实有两种情况：
	    //1：如果amount = 0，那么组合数应该为0，这种情况我们特殊处理了，在上面特殊情况处
	    //2：如果amount！=0，那么组合数应该为1，因为我们后面打算：“当前amount”的组合数即是“当前amount分别减去coin”的组合数值之和（sum：因为coins是数组，有多种硬币）
	    //						                   所以amount=0，其实是为了服务amount - count = 0 的情况，所以是1
	    res[0] = 1;
	    
	    //对于大于当前coin的amount，有  “当前amount”的组合数即是“当前amount分别减去coin”的组合数值之和
	    //					        即                  x     +=          x - coin
	    for (int coin : coins) {
		     for (int x = coin; x < amount + 1; ++x) {
		         res[x] += res[x - coin];
		     }
	     }
	    return res[amount];
    }
}
