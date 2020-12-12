package leetCode;

import java.util.*;

public class LC46_全排列 {
	//经典回溯问题
	/**
	 * 46. 全排列
		给定一个 没有重复 数字的序列，返回其所有可能的全排列。
		
		示例:
		输入: [1,2,3]
		输出:
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

	//全局变量 ： 存放最终结果集
	static List<List<Integer>> res = new ArrayList<>();
	
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        //存放单次结果
        LinkedList<Integer> temp = new LinkedList<>();
        process(nums,temp);
        return res;
    }

    public static void process(int[] nums , LinkedList<Integer> temp){
        //递归结束条件
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
