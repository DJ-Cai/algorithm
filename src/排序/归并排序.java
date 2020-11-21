package ����;

/*
 * 2019.10.27 
 * �鲢�����̺��ŷ��ε�˼��,���ֵ����򣬲��˷�����
 */
public class �鲢���� {
	public static void main(String[] args) {
		int[] arr = getRandomArrays.getRandomArrays(10, 20);
		System.out.print("����ǰ��");
		for (int a : arr)
			System.out.print(a + " ");
		
		
		System.out.println();
		mergeSort(arr);
		
		System.out.print("�����");
		for (int a : arr)
			System.out.print(a + " ");
	}

	private static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		sortProcess(arr, 0, arr.length-1);

	}

	private static void sortProcess(int[] arr, int L, int R) {
		//�����
		if (L<0 || R > arr.length || L == R || arr == null || arr.length < 2  )
			return;
		int mid = L + (R - L) / 2;
		sortProcess(arr, L, mid);
		sortProcess(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	private static void merge(int[] arr, int L, int mid, int R) {
		//����
//		System.out.println("L��mid��R  : "+L+"  "+mid+"   "+R+"   ");
		int p1 = L;
		int p2 = mid + 1;	
		int[] temp = new int[R-L+1];
		
		
		for (int i = 0; i < temp.length; i++) {
			if(p1>mid)					temp[i]=arr[p2++];
			else if(p2>R)				temp[i]=arr[p1++];
			else if(arr[p1]<arr[p2])	temp[i]=arr[p1++];
			else 						temp[i]=arr[p2++];
		}


		for (int i = 0; i < temp.length; i++) {
			//ϸ�ڣ�L+i
			arr[L + i] = temp[i];
		}

	}

}
