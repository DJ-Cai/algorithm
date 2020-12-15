package leetCode;

public class LC738_�������������� {
	
	public static void main(String[] args) {
		//һ��ʼ�ĺ�������������ʱ�Ժ�ʼ˼�����Ż�
		System.out.println(monotoneIncreasingDigits(668841));
		
		System.out.println(monotoneIncreasingDigitsTwo(668841));
	}

	//������̰�ģ��ӵ�λ����λ�Ҳ����ϵ���������λ��������λ-1����λȫ��Ϊ9����
	public static int monotoneIncreasingDigitsTwo(int N) {
		//˳���Ż�����toArr()����
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
	
	
	
	//��һ:����
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
        //���N��λ��
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
