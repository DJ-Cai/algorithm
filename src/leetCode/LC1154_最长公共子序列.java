package leetCode;

public class LC1154_最长公共子序列 {
	/**
	 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
		一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
		例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
		若这两个字符串没有公共子序列，则返回 0。
		
		示例 1:
		输入：text1 = "abcde", text2 = "ace" 
		输出：3  
		解释：最长公共子序列是 "ace"，它的长度为 3。
	 */
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
	}
	
	public static int longestCommonSubsequence(String text1, String text2) {
		if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
			return 0;
		}
		//res代表在  text1的前i-1个  和  text2的前j-1个  子串中，最长公共子序列长度
		int[][] res = new int[text1.length() + 1][text2.length() + 1];
		//遍历这个dptable，如果charAt相等，则此处最长公共子序列长度等于此处左上角子序列长度+1
		//				如果charAt不相等，则此处最长公共子序列长度等于此处左边或上面的最大值
		for(int i = 1 ; i < res.length ; i++) {
			for(int j = 1 ; j < res[i].length ; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					res[i][j] = res[i-1][j-1]+1;
				}else {
					res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
				}
			}
		}
		return res[text1.length()][text2.length()];
    }
	
}
