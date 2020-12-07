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
		 * 将a0视作最小值，遍历数组进行比较交换。遍历结束后无视a0，将a1视作最小值，循环。
		 */
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<=arr.length-1;j++)
				if(arr[i]>arr[j])
					Swap.swap(arr, i, j);
		}
	}
}
