package ��ָOffer;

import java.util.Arrays;

public class O07_�ؽ������� {

	/**
	 * ��ָ Offer 07. �ؽ�������
		����ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�
		
		���磬����
		ǰ����� preorder = [3,9,20,15,7]
		������� inorder = [9,3,15,20,7]
		�������µĶ�������
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		
		���ƣ�
		0 <= �ڵ���� <= 5000
	 */
	
	public static void main(String[] args) {
		buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
	}

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        //���ľ��ǵݹ飬�ҵ�ǰ�ڵ�--ǰ�����ȷ����ǰ�ڵ㣬�������ȷ����������
        TreeNode res = process(preorder,inorder);
        return res;
        
    }

    public static TreeNode process(int[] preorder , int[] inorder){
        //�ݹ��������
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        //ǰ������ĵ�һ���ڵ�һ����������Ľڵ�
        TreeNode node = new TreeNode(preorder[0]);
        //����һ����ʱ�ı��������ڼ�¼ǰ������ĵ�һ��ֵ�����������λ��
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
