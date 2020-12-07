package SortAlgorithm;

/*
 * 2019.10.28
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = GetRandomArrays.getRandomArrays(10, 20);
		System.out.print("����ǰ��");
		for (int a : arr)
			System.out.print(a + " ");
		System.out.println();
		qucikSort(arr);
		
		System.out.println();
		
		System.out.print("�����");
		for (int a : arr)
			System.out.print(a + " ");
	}

	private static void qucikSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		quickProcess(arr, 0, arr.length - 1);
	}

	private static void quickProcess(int[] arr, int L, int R) {
		if (L<0 || R > arr.length || L == R || arr == null || arr.length < 2  )
			return;
		if (L < R) {
			//�������
//			swap.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
			//����ȡ��:��ȷ��Ӧ��һ���ط�Ϊ���ֵ����ȥȷ��ʣ�������нϴ���Ǹ�
			int mid = L+((R-L)>>1);
			if(arr[L]<arr[R]) {
				Swap.swap(arr, L, R);
			}else if(arr[L]<arr[mid]) {
				Swap.swap(arr, L, mid);
			}else if(arr[mid]>arr[R]) {
				Swap.swap(arr, mid, R);
			}
			
			//������С���ģ���ת��Ϊ��������
//			if(R-L+1<=4) {
//				��������
//				return;
//			}
			int[] p = quick(arr, L, R);
			quickProcess(arr, L, p[0]);
			quickProcess(arr, p[1], R);
		}
	}

	private static int[] quick(int[] arr, int L, int R) {
		int less = L - 1;//��ʾ�����ڱ�arr[R]������ĩβԪ��С������
		int more = R + 1;//��ʾ�����ڱ�arr[R]������ĩβԪ�ش������
		int cur = L;//���׸�Ԫ�ؿ�ʼ�Ƚ�
		int key = arr[R];
		while (cur < more) {
			if (arr[cur] < key)
				Swap.swap(arr, ++less, cur++);
			else if (arr[cur] > key)
				//��һ�ν�����ʵ�Ǻ�arr[R]���ģ���ʱ�ı���arr[R]����һֱ���Ǻ�key�ȣ�key=arr[R]
					Swap.swap(arr, --more, cur);
			else {
				cur++;//���ڵ����
			}
		}
//		System.out.println(less+"    "+more);
		
		return new int[] { less, more };//��������Ԫ�أ�С��arr[R]������arr[R]---Ҫ������������Ļ�����Ҫ+1 -1
	}
}
