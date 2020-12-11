package ��ָOffer;

public class O04_��ά�����еĲ��� {

	/**
	 * ��ָ Offer 04. ��ά�����еĲ�����һ�� n * m �Ķ�ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
	 * �����һ����Ч�ĺ���������������һ����ά�����һ���������ж��������Ƿ��и�������
		ʾ��:
		���о��� matrix ���£�
		
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		���� target = 5������ true��
		���� target = 20������ false��
	 */
	
	public static void main(String[] args) {
		System.out.println(findNumberIn2DArray(new int[][] { {1,   4,  7, 11, 15} , 
															 {2,   5,  8, 12, 19} ,
															 {3,   6,  9, 16, 22} ,
															 {10, 13, 14, 17, 24} , 
															 {18, 21, 23, 26, 30} }, 5));
	}
	
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //����˼·�������Ͻǿ�ʼ������������һ�����⣺���matrix[i][j] < target�������»��������أ�
        //���Ը��õĽⷨӦ���ҿ���ѡ��ĵط�==���Ͻǿ�ʼ������С��target�������ߣ�������������
        int i = 0 ;  //����
        int j = matrix[0].length - 1; //����
        while(i < matrix.length && j >= 0 ){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
