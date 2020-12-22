package leetCode;

public class LC31_��һ������ {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,5};
		nextPermutation(arr);
		for(int i : arr) {
			System.out.print(i + "   ");
		}
	}
	
	
    //˼·������������1����ߵ�С����Ҫ�����ұ� 2���ұߵĴ�����Ҫ����С  
    //�����Ժ���������С�����Ԫ��
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return ;   
        }
        //ҪС�������ң��ʹ��ұ���������,��һ��С���ұ�Ԫ�ص�
        int smallNum = 0;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                smallNum = i;
                break;
            }
        }
        //Ҫ��������С���ʹ��������ң���һ������С���ģ��ͱȽ�С��
        int bigNum = smallNum;
        for(int i = nums.length - 1 ; i > smallNum ; i--){
            if(nums[i] > nums[smallNum]){
                bigNum = i;
                break;
            }
        }
        //���û�ҵ�������֤��С����󣬽���֤����С����forѭ����ʧ�ܵģ�smallNum = 0 ��Ϊ���ֵ��
        //�����������鶼�ǽ���ģ�ֱ������ͺá�
        if(smallNum == bigNum){
            sort(nums,smallNum);
            return ;
        }
        //����
        swap(nums,smallNum,bigNum);
        //����������С�����Ԫ��(ϸ�ڣ������� ������С�����Ԫ����ʵ�ǽ���ģ��������һ����С���ʹ����Ĺ��̾ͺ���)
        sort(nums,smallNum+1);
    }

    public static void swap(int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums, int index ){
        //���Կ�����Ҫ��ת��������������
        int last = nums.length - 1;
        while(index < last){
            swap(nums,index++,last--);
        }
    }
}
