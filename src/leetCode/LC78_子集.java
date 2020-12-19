package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78_�Ӽ� {
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		subsets(nums);
		for(List<Integer> list : res) {
			for(Integer integer : list) {
				System.out.print(integer +",");
			}
			System.out.println();
		}
		
		System.out.println("====================");
		
		res.clear();
		
		backTrack(nums,0,new ArrayList<Integer>());
		for(List<Integer> list : res) {
			for(Integer integer : list) {
				System.out.print(integer +",");
			}
			System.out.println();
		}
	}
	
    static List<List<Integer>> res = new ArrayList<>();
    
    //��һ���ݹ飻   ��Ϊ������Ӽ�����ͨ����������Ӽ���á������޸��������Ӽ��������½�����װ��====�����forѭ����
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        //��¼���������һ��Ԫ�أ�
        int last = nums[nums.length - 1];
        //������ʵ�����Ż�������һ��RightIndex �����±꣬�Ϳ��Բ�����������
        subsets(Arrays.copyOfRange(nums,0,nums.length - 1));
        
        int size = res.size(); // ��������forѭ������i<res.size()==��Ϊres.add�� size�����˱仯
        for(int i = 0 ; i < size ; i++){
        	//����ֱ��res.get(i)==��Ϊ���������½�һ��list������ָ���Ǹ�list
        	List<Integer> newList = new ArrayList<Integer>(res.get(i));
        	newList.add(last);
            res.add(newList);

        }
        return res;
    }
    
    //����������  
    public static void backTrack(int[] nums , int index , ArrayList<Integer> tmp) {
    	//�κ�һ����������tmp��������⣬��Ҫ��������
    	res.add(new ArrayList<>(tmp));
    	//��indexΪ���������飬�����Ժ�ݹ�===��ζ���������ʱ�̶������ˣ��������������
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack( nums, i+1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
