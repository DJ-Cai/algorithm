package SortAlgorithm;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arrs=GetRandomArrays.getRandomArrays(30, 20);
		for(int i: arrs) {
			System.out.print(i+" ");
		}
		System.out.println();
		selectSort(arrs);
		for(int i: arrs) {
			System.out.print(i+" ");
		}

 		
	}

	private static void selectSort(int[] arr ) {
		/*
		 * ��a0������Сֵ������������бȽϽ�������������������a0����a1������Сֵ��ѭ����
		 */
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<=arr.length-1;j++)
				if(arr[i]>arr[j])
					Swap.swap(arr, i, j);
		}
	}
}
