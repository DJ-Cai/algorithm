package 剑指Offer;

import java.util.Arrays;

public class O07_重建二叉树 {

	/**
	 * 剑指 Offer 07. 重建二叉树
		输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
		
		例如，给出
		前序遍历 preorder = [3,9,20,15,7]
		中序遍历 inorder = [9,3,15,20,7]
		返回如下的二叉树：
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		
		限制：
		0 <= 节点个数 <= 5000
	 */
	
	public static void main(String[] args) {
		buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
	}

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        //核心就是递归，找当前节点--前序遍历确定当前节点，中序遍历确定左右子树
        TreeNode res = process(preorder,inorder);
        return res;
        
    }

    public static TreeNode process(int[] preorder , int[] inorder){
        //递归结束条件
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        //前序遍历的第一个节点一定是最上面的节点
        TreeNode node = new TreeNode(preorder[0]);
        //定义一个暂时的变量，用于记录前序遍历的第一个值在中序遍历的位置
        int temp = 0;
        for(int i = 0 ; i < inorder.length ; i++){
            if(inorder[i] == preorder[0]){
                temp = i;
            }
        }
        node.left = process(Arrays.copyOfRange(preorder,1,temp + 1) , Arrays.copyOfRange(inorder,0,temp));
        node.right = process(Arrays.copyOfRange(preorder,temp + 1,preorder.length),Arrays.copyOfRange(inorder,temp+1,inorder.length));
        return node;
    }   
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
