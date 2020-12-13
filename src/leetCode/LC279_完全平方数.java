package leetCode;

public class LC279_完全平方数 {
	
	public static void main(String[] args) {
		System.out.println(numSquares(18));
	}
	
	//优化后：力扣40ms 
	//这题优化到这，还要优化只能上数学方法了：四平方数定理
    public static int numSquares(int n) {
        //定义：记录从1~n的最小平方数
        int[] res = new int[n + 1];
        //填充列表
        for(int i = 1 ; i < res.length ; i++){
            res[i] = i;
            for(int j = 0 ;  i - j * j >= 0 ; j++){
                res[i] = Math.min(res[i],res[i - j*j] + 1);
            }
        }
        return res[res.length - 1];
    }
    
    //未优化前：跑力扣平均880ms
    public int numSquaresBefore(int n) {
        //定义：记录从1~n的最小平方数
        int[] res = new int[n + 1];
        
        //少了一次遍历数组操作
        for(int i = 0 ; i < res.length ;i++){
            res[i] = i;
        }
        
        //填充列表
        for(int i = 1 ; i < res.length ; i++){
            for(int j = 0 ;  j < i ; j++){
            	//少了N次判断操作
                if(i - j * j >= 0)
                    res[i] = Math.min(res[i],res[i - j*j] + 1);
            }
        }
        return res[res.length - 1];
    }
}
