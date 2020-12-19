package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LC77_��� {
//	77. ���
//	������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
//	ʾ����
//	����: n = 4, k = 2
//	���:
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
     * @param index:��¼��ǰ��Ҫȷ����������==����֮ǰ���Ѿ�ȫ��ȷ��
     * @param temp��
     */
    public void process(int n , int k , int index , List<Integer> temp){
    	//�ﵽ��������������
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
        }
        //����������==��ѡ���б�
        for(int i = index ; i <= n ; i++){
            temp.add(i);
            process(n,k,i+1,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
