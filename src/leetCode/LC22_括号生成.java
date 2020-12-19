package leetCode;

import java.util.*;

public class LC22_括号生成 {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	
    static List<String> res = new ArrayList<>();
    static char[] temp = new char[]{'(' , ')'};
    //n是生成括号的对数，所以应该有n个左括号和n个右括号
    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(0,0,n,sb);
        return res;
    }


    public static void backtrack(int left , int right , int n , StringBuilder sb){
        if(left == n && right ==n){
            res.add(new String(sb));
        }
        if(right > left || left > n){
            return;
        }

        //往sb里添加'('或')'
        sb.append(temp[0]);
        backtrack(left + 1 , right , n,sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(temp[1]);
        backtrack(left, right+1 , n,sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
