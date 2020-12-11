package 剑指Offer;

public class O04_二维数组中的查找 {

	/**
	 * 剑指 Offer 04. 二维数组中的查找在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
		示例:
		现有矩阵 matrix 如下：
		
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		给定 target = 5，返回 true。
		给定 target = 20，返回 false。
	 */
	
	public static void main(String[] args) {
		System.out.println(findNumberIn2DArray(new int[][] { {1,   4,  7, 11, 15} , 
															 {2,   5,  8, 12, 19} ,
															 {3,   6,  9, 16, 22} ,
															 {10, 13, 14, 17, 24} , 
															 {18, 21, 23, 26, 30} }, 5));
	}
	
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //正常思路：从左上角开始遍历，但会有一个问题：如果matrix[i][j] < target，该往下还是往右呢？
        //所以更好的解法应该找可以选择的地方==右上角开始遍历，小于target就往下走，大于则往左走
        int i = 0 ;  //最上
        int j = matrix[0].length - 1; //最右
        while(i < matrix.length && j >= 0 ){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
