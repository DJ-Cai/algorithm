package SortAlgorithm;

/*
 * 2019.10.28
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = GetRandomArrays.getRandomArrays(10, 20);
		System.out.print("排序前：");
		for (int a : arr)
			System.out.print(a + " ");
		System.out.println();
		qucikSort(arr);
		
		System.out.println();
		
		System.out.print("排序后：");
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
			//随机快排
//			swap.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
			//三数取中:先确保应该一个地方为最大值，再去确定剩下两个中较大的那个
			int mid = L+((R-L)>>1);
			if(arr[L]<arr[R]) {
				Swap.swap(arr, L, R);
			}else if(arr[L]<arr[mid]) {
				Swap.swap(arr, L, mid);
			}else if(arr[mid]>arr[R]) {
				Swap.swap(arr, mid, R);
			}
			
			//数量若小于四，则转换为插入排序
//			if(R-L+1<=4) {
//				插入排序
//				return;
//			}
			int[] p = quick(arr, L, R);
			quickProcess(arr, L, p[0]);
			quickProcess(arr, p[1], R);
		}
	}

	private static int[] quick(int[] arr, int L, int R) {
		int less = L - 1;//表示数组内比arr[R]即数组末尾元素小的区域。
		int more = R + 1;//表示数组内比arr[R]即数组末尾元素大的区域。
		int cur = L;//从首个元素开始比较
		int key = arr[R];
		while (cur < more) {
			if (arr[cur] < key)
				Swap.swap(arr, ++less, cur++);
			else if (arr[cur] > key)
				//第一次交换其实是和arr[R]换的，此时改变了arr[R]、但一直都是和key比，key=arr[R]
					Swap.swap(arr, --more, cur);
			else {
				cur++;//等于的情况
			}
		}
//		System.out.println(less+"    "+more);
		
		return new int[] { less, more };//返回两个元素：小于arr[R]、大于arr[R]---要代表数量意义的话，还要+1 -1
	}
}
