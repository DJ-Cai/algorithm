package SortAlgorithm;

public class InsertSort {
	public static void main(String[] args) {
		int[] arrs = GetRandomArrays.getRandomArrays(20, 20);
		System.out.println("排序前");
		for (int i : arrs) {
			System.out.print(i + " ");
		}
		
		
		System.out.println();
		insertSort(arrs);
		
		
		System.out.println("排序后");
		for (int i : arrs) {
			System.out.print(i + " ");
		}

	}

	private static void insertSort(int[] arr) {
		/*
		 * 起初，将a0视作一个已排好的有序序列，添加a1进去，进行比较交换，（倒着做排序）
		 */
		if (arr.length < 2 || arr == null)
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			//i是有序序列
			int j = i+1;
			int temp = arr[j];
			while( j > 0 && temp < arr[j-1]) {
				arr[j] = arr[--j];
			}
			arr[j] = temp;
			
		}
	}
}
