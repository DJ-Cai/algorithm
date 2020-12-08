package algorithm;

public class No518_��Ǯ�һ� {
	/**
	 * ��Ǯ�һ��򣺸�����ͬ����Ӳ�Һ�һ���ܽ�д��������������Դճ��ܽ���Ӳ�������������ÿһ������Ӳ�������޸��� 
		����: amount = 5, coins = [1, 2, 5]
				���: 4
				����: �����ַ�ʽ���Դճ��ܽ��:
				5=5
				5=2+2+1
				5=2+1+1+1
				5=1+1+1+1+1
	 */
	
	public static void main(String[] args) {
		System.out.println(change(5,new int[] {1,2,5}));
	}
	
	public static int change(int amount, int[] coins) {
	    if(amount == 0 || coins == null || coins.length == 0){
	        return 0;
	    }
	    //�ֱ�����С��ָ��amount��ֵ�Ľ��
	    int[] res = new int[amount + 1];
	    //res[0]��ʵ�����������
	    //1�����amount = 0����ô�����Ӧ��Ϊ0����������������⴦���ˣ����������������
	    //2�����amount��=0����ô�����Ӧ��Ϊ1����Ϊ���Ǻ�����㣺����ǰamount������������ǡ���ǰamount�ֱ��ȥcoin���������ֵ֮�ͣ�sum����Ϊcoins�����飬�ж���Ӳ�ң�
	    //						                   ����amount=0����ʵ��Ϊ�˷���amount - count = 0 �������������1
	    res[0] = 1;
	    
	    //���ڴ��ڵ�ǰcoin��amount����  ����ǰamount������������ǡ���ǰamount�ֱ��ȥcoin���������ֵ֮��
	    //					        ��                  x     +=          x - coin
	    for (int coin : coins) {
		     for (int x = coin; x < amount + 1; ++x) {
		         res[x] += res[x - coin];
		     }
	     }
	    return res[amount];
    }
}
