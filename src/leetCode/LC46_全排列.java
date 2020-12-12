package leetCode;

import java.util.*;

public class LC46_ȫ���� {
	//�����������
	/**
	 * 46. ȫ����
		����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
		
		ʾ��:
		����: [1,2,3]
		���:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
	 */
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		permute(nums);
		for(List<Integer> temp : res) {
			System.out.print("[");
			for(Integer integer : temp) {
				System.out.print(integer + ",");
			}
			System.out.println("]");
		}
	}

	//ȫ�ֱ��� �� ������ս����
	static List<List<Integer>> res = new ArrayList<>();
	
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        //��ŵ��ν��
        LinkedList<Integer> temp = new LinkedList<>();
        process(nums,temp);
        return res;
    }

    public static void process(int[] nums , LinkedList<Integer> temp){
        //�ݹ��������
        if(temp.size() == nums.length){
            res.add(new LinkedList(temp));
            return ;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            process(nums,temp);
            temp.removeLast();
        }
    }
}
