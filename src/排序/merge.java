package ≈≈–Ú;

public class merge {
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		mergeSortProcess(arr,0,arr.length-1);
	}
	
	public static void mergeSortProcess(int[] arr , int L ,int R) {
		if(L < 0 || L == R || arr == null ||arr.length < 2 || L>R || R > arr.length) {
			return;
		}
		int mid = L + (R - L)/2;
		mergeSortProcess(arr, L, mid);
		mergeSortProcess(arr, mid+1, R);
		merge(arr,L,mid,R);
	}
	
	public static void merge(int[] arr , int L ,int mid ,int R) {
		int p1 = L;
		int p2 = mid+1;
		int[] temp = new int[R-L+1];
		
		for(int i = 0 ; i < temp.length ; i++) {
			if(p1>mid)					temp[i]=arr[p2++];
			else if(p2>R)				temp[i]=arr[p1++];
			else if(arr[p1]<arr[p2])	temp[i]=arr[p1++];
			else 						temp[i]=arr[p2++];
		}
		for(int i = 0 ; i < temp.length ; i++) {
			arr[L + i] = temp[i];
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("***********");
		int[] arr = getRandomArrays.getRandomArrays(10, 20);
		System.out.print("≈≈–Ú«∞£∫");
		for (int a : arr)
			System.out.print(a + " ");
		
		
		System.out.println();
		mergeSort(arr);
		
		System.out.print("≈≈–Ú∫Û£∫");
		for (int a : arr)
			System.out.print(a + " ");
	}
}
