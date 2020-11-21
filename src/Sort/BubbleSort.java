package Sort;


public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arrs=GetRandomArrays.getRandomArrays(10, 50);
		for(int arr:arrs)
			System.out.print(arr+" ");
		System.out.println();
		bubbleSort(arrs);
		
		System.out.println();
		
		for(int arr:arrs)
			System.out.print(arr+" ");
	}
	
	
	public static void bubbleSort(int[] arrs) {  //冒泡核心实现 +优化
		/*
		 * 相邻两个元素进行比较交换后++
		 * 优化：定义一个flag,判断if语句有没有执行，若没有，则数组已排好序，直接跳出循环。
		 */
		for(int i=0;i<arrs.length;i++) {
			boolean flag=true;
			for(int j=0;j<arrs.length-1-i;j++) {
				if(arrs[j]>arrs[j+1]) {
					Swap.swap(arrs, j, j+1);
					flag=false;
				}
			}
			if(flag) {
				System.out.println("结束");
				break;
				}
		}
	}
}




