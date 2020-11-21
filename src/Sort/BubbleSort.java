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
	
	
	public static void bubbleSort(int[] arrs) {  //ð�ݺ���ʵ�� +�Ż�
		/*
		 * ��������Ԫ�ؽ��бȽϽ�����++
		 * �Ż�������һ��flag,�ж�if�����û��ִ�У���û�У����������ź���ֱ������ѭ����
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
				System.out.println("����");
				break;
				}
		}
	}
}




