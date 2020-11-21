package Sort;


public class HeapSort {
	public static void main(String[] args) {
		int[] arr = GetRandomArrays.getRandomArrays(10, 20);
		for (int a : arr)
			System.out.print(a + " ");
		heapSort(arr);
		System.out.println();
		for (int a : arr)
			System.out.print(a + " ");
	}

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			//����
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		Swap.swap(arr, 0, --heapSize);// �������е㡰ɾ����ζ��������
		//����
		while (heapSize > 0) {
			heapify(arr, 0, heapSize); // ɾ���³��������γɴ����
			Swap.swap(arr, 0, --heapSize);
		}
	}

	/*
	 * ���ӽڵ���д�С�Ƚ��뽻���Ĺ��� || һ��ֵ��С�Ժ����³��Ĳ��� ---------
	 */
	private static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // �ҳ��ϴ���ӽڵ��λ��
			largest = arr[largest] > arr[index] ? largest : index; // �ҳ�����ӽڵ��븸����ĸ���
			if (largest == index) {   //��ֹlargest��indexͬΪ0ʱ����ѭ��
				break;
			}
			Swap.swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	/*
	 * ɾ���ڶ���ɾ��ͷ���Ĺ��̣�ͷ����β��㽻����size-1��heapify
	 */
	/*
	 * �����ڶ��в�����Ĺ���
	 */
	private static void heapInsert(int[] arr, int index) {
		// ��ֹ����arr[0]��arr[0]���бȽϵĹ���
		while (arr[index] > arr[(index - 1) / 2]) {
			Swap.swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
		
	}
}
