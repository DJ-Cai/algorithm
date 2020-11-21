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
			//建堆
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		Swap.swap(arr, 0, --heapSize);// 交换，有点“删”的味道在里面
		//排序
		while (heapSize > 0) {
			heapify(arr, 0, heapSize); // 删完下沉，重新形成大根堆
			Swap.swap(arr, 0, --heapSize);
		}
	}

	/*
	 * 和子节点进行大小比较与交换的过程 || 一个值变小以后往下沉的操作 ---------
	 */
	private static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // 找出较大的子节点的位置
			largest = arr[largest] > arr[index] ? largest : index; // 找出大的子节点与父结点哪个大
			if (largest == index) {   //防止largest和index同为0时的死循环
				break;
			}
			Swap.swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	/*
	 * 删：在堆中删除头结点的过程，头结点和尾结点交换，size-1，heapify
	 */
	/*
	 * 增：在堆中插入结点的过程
	 */
	private static void heapInsert(int[] arr, int index) {
		// 防止出现arr[0]和arr[0]进行比较的过程
		while (arr[index] > arr[(index - 1) / 2]) {
			Swap.swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
		
	}
}
