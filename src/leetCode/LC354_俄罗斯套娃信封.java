package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LC354_俄罗斯套娃信封 {
	
	/**
	 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
		请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
		说明:
		不允许旋转信封。
		
		示例:
		输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
		输出: 3 
		解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
	 * @param args
	 */
	
	public static void main(String[] args) {
		int res = maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}});
		System.out.println(res);
	}
    public static int maxEnvelopes(int[][] envelopes) {
    	if(envelopes == null ||  envelopes.length == 0 ||envelopes[0].length == 0 ){
            return 0;
        }

        //这题和最长递增子序列很像，就是绕了个弯
        //将宽按升序排序，高按降序排序，再求以高为标准的最长递增子序列
        //会得到：前面符合标准的信封，都能放进后面符合标准的信封中，又是最长，所以是解
        //[PS:注释部分是我debug过程，一开始以为返回值应该是4，把整个过程都打印出来了，还是要想好再下手]

        //1、给数组按宽高两个维度进行排序
        Arrays.sort(envelopes , new Comparator<int[]>(){
            public int compare(int[] a1 , int[] a2){
                //宽相等按高降序排，不等按宽升序排
                return a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0];
            }
        });
//        for(int i = 0 ; i < envelopes.length ; i++) {
//        	System.out.println("envelopes["+i+"] :" + envelopes[i][0] + " " + envelopes[i][1]);
//        }
        
        
        //2、排好序以后，按高来做最长递增子序列
        int[] temp = new int[envelopes.length];
        for(int i = 0 ; i < temp.length ; i++){
            temp[i] = envelopes[i][1];
        }
//        for(int i = 0 ; i < temp.length ; i++) {
//        	System.out.println("temp[" + i + "] : " + temp[i]);
//        }
        return Longest(temp);


    }

    public static int Longest(int[] arr){
        if(arr == null || arr.length == 0){
            return 0 ;
        }
        //定义：以当前元素为结尾的最长递增子序列的长度
        int[] temp = new int[arr.length];
        //注意点1：最长递增子序列，最短为自己一个元素，所有初始化为1 
        Arrays.fill(temp,1);
        
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j]){
                    temp[i] = Math.max(temp[i],temp[j] + 1);
                }
            }
        }
        //注意点2：由于我们的定义，所有temp数组赋值完成后，需要遍历求最大值
        int res = 0 ;
        for(int i = 0 ; i < temp.length ; i++) {
        	// System.out.println("temp[" + i + "] : " + temp[i]);
        	res= Math.max(res, temp[i]);
        }
        return res;
    }
}
