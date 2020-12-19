package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LC77_组合 {
//	77. 组合
//	给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//	示例：
//	输入: n = 4, k = 2
//	输出:
//	[
//	  [2,4],
//	  [3,4],
//	  [2,3],
//	  [1,2],
//	  [1,3],
//	  [1,4],
//	]
	
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        process(n,k,1,temp);
        return res;
    }

    /**
     * 
     * @param n 
     * @param k
     * @param index:记录当前需要确定下来的数==》这之前的已经全部确定
     * @param temp：
     */
    public void process(int n , int k , int index , List<Integer> temp){
    	//达到放入结果集的条件
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
        }
        //遍历决策树==》选择列表
        for(int i = index ; i <= n ; i++){
            temp.add(i);
            process(n,k,i+1,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
