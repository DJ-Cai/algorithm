package SortAlgorithm;

public class InsertSort {
	public static void main(String[] args) {
		int[] arrs = GetRandomArrays.getRandomArrays(20, 20);
		System.out.println("����ǰ");
		for (int i : arrs) {
			System.out.print(i + " ");
		}
		
		
		System.out.println();
		insertSort(arrs);
		
		
		System.out.println("�����");
		for (int i : arrs) {
			System.out.print(i + " ");
		}

	}

	private static void insertSort(int[] arr) {
		/*
		 * �������a0����һ�����źõ��������У����a1��ȥ�����бȽϽ�����������������
		 */
		if (arr.length < 2 || arr == null)
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			//i����������
			int j = i+1;
			int temp = arr[j];
			while( j > 0 && temp < arr[j-1]) {
				arr[j] = arr[--j];
			}
			arr[j] = temp;
			
		}
	}
}
