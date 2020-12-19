package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78_子集 {
	
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
    
    //法一：递归；   因为数组的子集可以通过子数组的子集求得【不是修改子数组子集，而是新建出来装饰====下面的for循环】
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        //记录数组里最后一个元素，
        int last = nums[nums.length - 1];
        //这里其实可以优化，传入一个RightIndex 最右下标，就可以不用子数组了
        subsets(Arrays.copyOfRange(nums,0,nums.length - 1));
        
        int size = res.size(); // 不可以在for循环里用i<res.size()==因为res.add后 size发生了变化
        for(int i = 0 ; i < size ; i++){
        	//不能直接res.get(i)==因为这样不会新建一个list，而是指向那个list
        	List<Integer> newList = new ArrayList<Integer>(res.get(i));
        	newList.add(last);
            res.add(newList);

        }
        return res;
    }
    
    //法二：回溯  
    public static void backTrack(int[] nums , int index , ArrayList<Integer> tmp) {
    	//任何一个传进来的tmp，都满足解，需要加入结果集
    	res.add(new ArrayList<>(tmp));
    	//以index为起点遍历数组，存入以后递归===意味着这个数暂时固定下来了，看这个数后的情况
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack( nums, i+1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
