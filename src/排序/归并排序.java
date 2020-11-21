package 排序;

/*
 * 2019.10.27 
 * 归并排序蕴含着分治的思想,二分的排序，不浪费排序
 */
public class 归并排序 {
	public static void main(String[] args) {
		int[] arr = getRandomArrays.getRandomArrays(10, 20);
		System.out.print("排序前：");
		for (int a : arr)
			System.out.print(a + " ");
		
		
		System.out.println();
		mergeSort(arr);
		
		System.out.print("排序后：");
		for (int a : arr)
			System.out.print(a + " ");
	}

	private static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		sortProcess(arr, 0, arr.length-1);

	}

	private static void sortProcess(int[] arr, int L, int R) {
		//分与合
		if (L<0 || R > arr.length || L == R || arr == null || arr.length < 2  )
			return;
		int mid = L + (R - L) / 2;
		sortProcess(arr, L, mid);
		sortProcess(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	private static void merge(int[] arr, int L, int mid, int R) {
		//排序
//		System.out.println("L和mid和R  : "+L+"  "+mid+"   "+R+"   ");
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
			//细节：L+i
			arr[L + i] = temp[i];
		}

	}

}
