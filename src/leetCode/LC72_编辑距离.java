package leetCode;

public class LC72_编辑距离 {
	/**
	 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
	你可以对一个单词进行如下三种操作：
	插入一个字符
	删除一个字符
	替换一个字符
	 
	示例 1：
	输入：word1 = "horse", word2 = "ros"
	输出：3
	解释：
	horse -> rorse (将 'h' 替换为 'r')
	rorse -> rose (删除 'r')
	rose -> ros (删除 'e')
	 */
	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}
	
	public static int minDistance(String word1, String word2) {
//		一开始无脑特殊处理了，但是这道题，两个字符串是可以为空为0的----这一点体现在初始化上
//		if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
//			return 0;
//		}
		//res:word1子串变为word2子串需要的最少操作次数
		int[][] res = new int[word1.length() + 1][word2.length() + 1];
		//所以需要一定的初始化：首行与首列
		for(int i = 0 ; i < res.length ; i++) {
			res[i][0] = i;
			//System.out.println(res[i][0]);
		}
		for(int i = 0 ; i < res[0].length ; i++) {
			res[0][i] = i;
			//System.out.println(res[0][i]);
		}
		//开始填充这个dpTable
		for(int i = 1; i < res.length ; i++) {
			for(int j = 1; j < res[0].length ; j++) {
				//填充规则：如果当前两个字符相等，那么他的次数应该等于没有这两个字符的时候的次数---可以理解为进行了不操作的操作
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					res[i][j] = res[i-1][j-1];
				}else {
					//如果不等，那么应该由之前的状态转化而来，取之前状态里的最小值，这里因为可以是替换，所以左上角那个table也需要考虑进来
					//这里其实可以思考一下，dptable每个相对位置的格子代表的状态：左上角代表着不操作，左边代表插入，上面代表删除
					res[i][j] = Math.min(res[i - 1][j - 1] + 1, Math.min(res[i - 1][j] + 1 , res[i][j-1] + 1));
				}
			}
		}
		return res[word1.length()][word2.length()];
    }
}
