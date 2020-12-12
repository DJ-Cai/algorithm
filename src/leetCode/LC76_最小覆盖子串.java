package leetCode;

import java.util.HashMap;

public class LC76_最小覆盖子串 {
	/**
	 * 76. 最小覆盖子串
		给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
		
		注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
		
		 
		示例 1：
		输入：s = "ADOBECODEBANC", t = "ABC"
		输出："BANC"
		示例 2：
		
		输入：s = "a", t = "a"
		输出："a"
		 
		提示：
		1 <= s.length, t.length <= 105
		s 和 t 由英文字母组成
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	 public static String minWindow(String s, String t) {
	        if(s == null || t == null || s.length() == 0 || t.length() == 0){
	            return "";
	        }
	        //记录t串中的字符种类与数量
	        HashMap<Character,Integer> need = new HashMap<Character, Integer>();
	        //记录s串的子串中的符合t串要求的字符种类和数量
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        //填充map
	        for(int i = 0 ; i < t.length() ; i++) {
	        	need.put(t.charAt(i) , need.getOrDefault(t.charAt(i),0) + 1);
	        }
	        
	        //窗口左右边界
	        int left = 0 , right = 0;
	        //最小覆盖子串的开始和长度
	        int start = 0 , len = Integer.MAX_VALUE;
	        //记录map里的size是否达到need的长度，达到意味着现在窗口里已经满足t了，需要开始收缩窗口
	        int size = 0;
	        
	        while(right < s.length()) {
	        	//记录右指针指向的字符
	        	char c = s.charAt(right);
	        	//右指针右移：将c纳入滑动窗口
	        	right ++ ;
	        	//如果需要该字符,则放入map里
	        	if(need.containsKey(c)) {
	        		map.put(c, map.getOrDefault(c, 0) + 1);
	        		//注意点1：这里一开始用的是==来比较两个Integer【应该使用equals函数，这里不改了】，导致LeetCode最后一个测试用例过不去，这里记录一下：包装类的比较不要用==
	        		//原因：Integer是对象，他会缓存-128~127的值，所以这范围内的值是从缓存池里拿，都是可以用==来比较的；但！！！！超过这个分为，会new一个Integer对象出来，==是不可能为true的
	        		if(map.get(c) == need.get(c)) {
	        			size++;
	        		}
	        	}
	        	
	        	//开始收缩窗口
	        	
	        	while(size == need.size()) {
	        		//更新最小覆盖子串的长度与开头
	        		if(right - left < len ) {
	        			start = left;
	        			len = right - left;
	        		}
	        		//记录左指针指向的字符
	        		char c2 = s.charAt(left);
	        		//收缩床窗口
	        		left++;
	        		//如果收缩窗口去掉的字符是所需要的字符，意味着窗口可能又不满足需求了，得根据意义跳出收缩窗口的代码
	        		if(need.containsKey(c2)) {
	        			//这里一开始用的是==来比较两个Integer，原因不重复赘述
	        			if(need.get(c2) == map.get(c2)) {
	        				size--;
	        			}
	        			//在map里移出一个c2字符
		        		map.put(c2, map.get(c2) - 1);
	        		}
	        		
	        	}
	        }
	        
	        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
	 }
}
