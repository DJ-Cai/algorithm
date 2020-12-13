package leetCode;

public class LC198_��ҽ��� {
	
//	198. ��ҽ���
//	����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
//	����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
//
//	ʾ�� 1��
//	���룺[1,2,3,1]
//	�����4
//	���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
//	     ͵�Ե�����߽�� = 1 + 3 = 4 ��
	
	public static void main(String[] args) {
		int res = rob(new int[] {1,2,3,1});
		System.out.println(res);
	}
	
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < res.length ; i ++){
            res[i] = Math.max(res[i-2] + nums[i] , res[i-1]);
        }
        return res[res.length -1];

        //ѹ��
        // if(nums == null || nums.length == 0){
        //     return 0;
        // }
        // int cur = nums[0];
        // int pre = 0;
        // for(int i = 1 ; i < nums.length ; i++){
        //     int temp = Math.max(cur , pre + nums[i]);
        //     pre = cur;
        //     cur = temp;
        // }
        // return cur;
    }
}
