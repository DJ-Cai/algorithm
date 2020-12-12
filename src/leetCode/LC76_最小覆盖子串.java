package leetCode;

import java.util.HashMap;

public class LC76_��С�����Ӵ� {
	/**
	 * 76. ��С�����Ӵ�
		����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ������ s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
		
		ע�⣺��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
		
		 
		ʾ�� 1��
		���룺s = "ADOBECODEBANC", t = "ABC"
		�����"BANC"
		ʾ�� 2��
		
		���룺s = "a", t = "a"
		�����"a"
		 
		��ʾ��
		1 <= s.length, t.length <= 105
		s �� t ��Ӣ����ĸ���
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	 public static String minWindow(String s, String t) {
	        if(s == null || t == null || s.length() == 0 || t.length() == 0){
	            return "";
	        }
	        //��¼t���е��ַ�����������
	        HashMap<Character,Integer> need = new HashMap<Character, Integer>();
	        //��¼s�����Ӵ��еķ���t��Ҫ����ַ����������
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        //���map
	        for(int i = 0 ; i < t.length() ; i++) {
	        	need.put(t.charAt(i) , need.getOrDefault(t.charAt(i),0) + 1);
	        }
	        
	        //�������ұ߽�
	        int left = 0 , right = 0;
	        //��С�����Ӵ��Ŀ�ʼ�ͳ���
	        int start = 0 , len = Integer.MAX_VALUE;
	        //��¼map���size�Ƿ�ﵽneed�ĳ��ȣ��ﵽ��ζ�����ڴ������Ѿ�����t�ˣ���Ҫ��ʼ��������
	        int size = 0;
	        
	        while(right < s.length()) {
	        	//��¼��ָ��ָ����ַ�
	        	char c = s.charAt(right);
	        	//��ָ�����ƣ���c���뻬������
	        	right ++ ;
	        	//�����Ҫ���ַ�,�����map��
	        	if(need.containsKey(c)) {
	        		map.put(c, map.getOrDefault(c, 0) + 1);
	        		//ע���1������һ��ʼ�õ���==���Ƚ�����Integer��Ӧ��ʹ��equals���������ﲻ���ˡ�������LeetCode���һ��������������ȥ�������¼һ�£���װ��ıȽϲ�Ҫ��==
	        		//ԭ��Integer�Ƕ������Ỻ��-128~127��ֵ�������ⷶΧ�ڵ�ֵ�Ǵӻ�������ã����ǿ�����==���Ƚϵģ��������������������Ϊ����newһ��Integer���������==�ǲ�����Ϊtrue��
	        		if(map.get(c) == need.get(c)) {
	        			size++;
	        		}
	        	}
	        	
	        	//��ʼ��������
	        	
	        	while(size == need.size()) {
	        		//������С�����Ӵ��ĳ����뿪ͷ
	        		if(right - left < len ) {
	        			start = left;
	        			len = right - left;
	        		}
	        		//��¼��ָ��ָ����ַ�
	        		char c2 = s.charAt(left);
	        		//����������
	        		left++;
	        		//�����������ȥ�����ַ�������Ҫ���ַ�����ζ�Ŵ��ڿ����ֲ����������ˣ��ø������������������ڵĴ���
	        		if(need.containsKey(c2)) {
	        			//����һ��ʼ�õ���==���Ƚ�����Integer��ԭ���ظ�׸��
	        			if(need.get(c2) == map.get(c2)) {
	        				size--;
	        			}
	        			//��map���Ƴ�һ��c2�ַ�
		        		map.put(c2, map.get(c2) - 1);
	        		}
	        		
	        	}
	        }
	        
	        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
	 }
}
