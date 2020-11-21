package 排序;

public class swap {
	public static void swap(int[] arr,int i,int j) {  //比较后的交换
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
