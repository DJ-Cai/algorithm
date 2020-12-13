package leetCode;

import java.util.Arrays;

public class LC213_��ҽ���� {
//	
//	213. ��ҽ��� II
//	����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
//
//	����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ ���ܹ�͵�Ե�����߽�
//
//	ʾ�� 1��
//	���룺nums = [2,3,2]
//	�����3
//	���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
//	
//	ʾ�� 2��
//	���룺nums = [1,2,3,1]
//	�����4
//	���ͣ��������͵�� 1 �ŷ��ݣ���� = 1����Ȼ��͵�� 3 �ŷ��ݣ���� = 3����
//	     ͵�Ե�����߽�� = 1 + 3 = 4 ��
	
	public static void main(String[] args) {
		int res = rob(new int[] {2,3,2});
		System.out.println(res);
	}
	
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        //�⻷����״ֻ������һ��������������ٵ�һ�䣬�����һ�䲻�ɴ�٣�������һ�䣬���һ�䲻�ɴ��
        return Math.max(
                            process(Arrays.copyOfRange(nums,1,nums.length)) , 
                            process(Arrays.copyOfRange(nums,0,nums.length - 1))
                        );

    }

    public static int process(int[] nums){
         if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = nums[0];
        int pre = 0;
        for(int i = 1 ; i < nums.length ; i++){
            int temp = Math.max(cur , pre + nums[i]);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
