package SortAlgorithm;

public class GetRandomArrays {

	public static int[] getRandomArrays(int size,int value) {  //获得随机数组
		int[] arr = new int [(int)((size)*Math.random())];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int) ((value+1)*Math.random()-(value*Math.random()));
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[]  arr = getRandomArrays(10, 10);
		for (int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}
}
