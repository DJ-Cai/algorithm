package leetCode;

public class LC279_��ȫƽ���� {
	
	public static void main(String[] args) {
		System.out.println(numSquares(18));
	}
	
	//�Ż�������40ms 
	//�����Ż����⣬��Ҫ�Ż�ֻ������ѧ�����ˣ���ƽ��������
    public static int numSquares(int n) {
        //���壺��¼��1~n����Сƽ����
        int[] res = new int[n + 1];
        //����б�
        for(int i = 1 ; i < res.length ; i++){
            res[i] = i;
            for(int j = 0 ;  i - j * j >= 0 ; j++){
                res[i] = Math.min(res[i],res[i - j*j] + 1);
            }
        }
        return res[res.length - 1];
    }
    
    //δ�Ż�ǰ��������ƽ��880ms
    public int numSquaresBefore(int n) {
        //���壺��¼��1~n����Сƽ����
        int[] res = new int[n + 1];
        
        //����һ�α����������
        for(int i = 0 ; i < res.length ;i++){
            res[i] = i;
        }
        
        //����б�
        for(int i = 1 ; i < res.length ; i++){
            for(int j = 0 ;  j < i ; j++){
            	//����N���жϲ���
                if(i - j * j >= 0)
                    res[i] = Math.min(res[i],res[i - j*j] + 1);
            }
        }
        return res[res.length - 1];
    }
}
