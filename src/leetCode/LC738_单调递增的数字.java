package leetCode;

public class LC738_单调递增的数字 {
	
	public static void main(String[] args) {
		//一开始的憨憨暴力法，超时以后开始思考与优化
		System.out.println(monotoneIncreasingDigits(668841));
		
		System.out.println(monotoneIncreasingDigitsTwo(668841));
	}

	//法二：贪心：从低位到高位找不符合单调递增的位数，将此位-1，后位全置为9即可
	public static int monotoneIncreasingDigitsTwo(int N) {
		//顺带优化憨憨toArr()方法
		if(N <= 9){
            return N;
        }
		char[] arr = Integer.toString(N).toCharArray();
		for(int i = arr.length-1 ; i > 0 ; i--) {
			if(arr[i] < arr[i-1]) {
				arr[i-1] -= 1;
				for(int j = i ; j < arr.length ; j++) {
					arr[j] = '9';
				}
			}
		}
		return Integer.parseInt(new String (arr));
	}
	
	
	
	//法一:暴力
    public static int monotoneIncreasingDigits(int N) {
        if(N <= 9){
            return N;
        }
        for( int cur = N ; cur > 0 ; cur--){
        	int[] arr = toArr(cur);
        	if(isRight(arr)) {
        		return cur;
        	}
        } 
        return 0;
    }

    private static boolean isRight(int[] arr) {
    	for(int i = 0 ; i < arr.length - 1; i++) {
    		if(arr[i] > arr[i+1]) {
    			return false;
    		}
    	}
		return true;
	}

	public static int[] toArr(int N){
        int temp = N;
        int size = 1;
        //求出N的位数
        while(temp >= 10){
            temp /= 10;
            size++;
        }
        int[] arr = new int[size];
        while(N > 0){
            arr[--size] = N % 10;
            N /= 10;
        }
        return arr;
    }
}
