package leetCode;

public class LC1312_最少插入次数构造回文串 {
	/**
	 * 1312. 让字符串成为回文串的最少插入次数
	给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
	请你返回让 s 成为回文串的 最少操作次数 。
	「回文串」是正读和反读都相同的字符串。
	
	示例 1：
	输入：s = "zzazz"
	输出：0
	解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
	 */
	//和最长回文子序列一样的思路，这里不过多注释了
	public static void main(String[] args) {
		System.out.println(minInsertions("abcd"));
	}
	
    public static int minInsertions(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[][] res = new int[s.length()][s.length()];
        for(int i = s.length() - 2 ; i >= 0 ;  i--){
            for(int j = i + 1 ; j < s.length() ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    res[i][j] = res[i+1][j-1];
                }else{
                    res[i][j] = Math.min(res[i+1][j] + 1 , res[i][j-1] + 1);
                }
            }
        }
        return res[0][res[0].length - 1];
    }
}
