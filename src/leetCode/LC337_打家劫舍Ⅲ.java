package leetCode;

public class LC337_��ҽ���� {

//	337. ��ҽ��� III
//	���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ�������� 
//	���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� 
//	�������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
//	�����ڲ���������������£�С͵һ���ܹ���ȡ����߽�
//
//	ʾ�� 1:
//	����: [3,2,3,null,3,null,1]
//	     3
//	    / \
//	   2   3
//	    \   \ 
//	     3   1
//
//	���: 7 
//	����: С͵һ���ܹ���ȡ����߽�� = 3 + 3 + 1 = 7.
	
    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = process(root);
        return Math.max(res[0],res[1]);
    }

    //��������ֵ����͵��max��͵��max
    public static int[] process(TreeNode root){
        //�ڵ�Ϊ�գ��򷵻�0
        if(root == null){
            return new int[2];
        }
        //��ڵ���������
        int[] left = process(root.left);
        //�ҽڵ���������
        int[] right = process(root.right);

        //������ֵ��ֵ
        int[] res = new int[2];
        //��͵��root = ���������ֵ + ���������ֵ
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0] , right[1]);
        //͵��root = root.val + ��͵root + �Ҳ�͵root
        res[1] = root.val + left[0] + right[0];

        //��ֵ���������ؽ��
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