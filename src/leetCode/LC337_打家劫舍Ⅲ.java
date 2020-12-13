package leetCode;

public class LC337_打家劫舍Ⅲ {

//	337. 打家劫舍 III
//	在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 
//	除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
//	如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//	计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//	示例 1:
//	输入: [3,2,3,null,3,null,1]
//	     3
//	    / \
//	   2   3
//	    \   \ 
//	     3   1
//
//	输出: 7 
//	解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
	
    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = process(root);
        return Math.max(res[0],res[1]);
    }

    //返回两个值：不偷根max和偷根max
    public static int[] process(TreeNode root){
        //节点为空，则返回0
        if(root == null){
            return new int[2];
        }
        //左节点的两种情况
        int[] left = process(root.left);
        //右节点的两种情况
        int[] right = process(root.right);

        //给返回值赋值
        int[] res = new int[2];
        //不偷此root = 左子树最大值 + 右子树最大值
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0] , right[1]);
        //偷此root = root.val + 左不偷root + 右不偷root
        res[1] = root.val + left[0] + right[0];

        //赋值结束，返回结果
        return res;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}