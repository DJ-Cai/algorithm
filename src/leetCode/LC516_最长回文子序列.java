package leetCode;

public class LC516_最长回文子序列 {
	/**
	 * 516. 最长回文子序列
	给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
	示例 1:
	输入:
	"bbbab"
	输出:
	4
	一个可能的最长回文子序列为 "bbbb"。
	
	明确子序列和子串子数组的区别：子序列不要求连续，其他两个要求
	 */
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
	}
	
	
	public static int longestPalindromeSubseq(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		//正常思路来说，找回文串，可以从中间或两边开始。但这里是回文“子序列”，而且要求“最长”，我们考虑动态规划
		//接下来考虑定义，ij（dptable的行列）分别代表什么？双指针，i从左到右遍历，j从右到左遍历
		//定义：res里装着当前ij指针包含的子串里所能成的最长回文子序列 --- 这就意味着，答案会放在table的右上角
		int[][] res = new int[s.length()][s.length()];
		//初始化：由于这样的定义，所以i=j的时候，意味着子串只有一个字符，所以值应该为1； 
		//还有一个限制：i从左到右遍历，j从右到左遍历，其实是无所谓的，只是说会有重复情况，我们可以去掉一半，即i > j 或者  j > i 的时候取0（注意如果j>i取0的话，答案应该在左下角）
		//默认初始化为0，所以这里不用操作
		for(int i = 0 ; i < res.length ; i++) {
			res[i][i] = 1;
		}
		//既然答案在右上角，遍历应该最后到右上角，我们从最下面开始从左到右填充dp table
		for(int i = s.length() - 2 ; i >= 0 ; i--) {
			for(int j = i + 1; j < s.length() ; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					res[i][j] = res[i+1][j-1] + 2;
				}else {
					res[i][j] = Math.max(res[i][j-1], res[i+1][j]);
				}
			}
		}
		return res[0][s.length()-1];
    }
	
}
