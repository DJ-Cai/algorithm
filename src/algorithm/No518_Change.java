package algorithm;

public class No518_Change {
	//��Ǯ�һ��򣺸�����ͬ����Ӳ�Һ�һ���ܽ�д��������������Դճ��ܽ���Ӳ�������������ÿһ������Ӳ�������޸��� 
	//	����: amount = 5, coins = [1, 2, 5]
	//			���: 4
	//			����: �����ַ�ʽ���Դճ��ܽ��:
	//			5=5
	//			5=2+2+1
	//			5=2+1+1+1
	//			5=1+1+1+1+1
	public static void main(String[] args) {
		change(5,new int[] {1,2,5});
	}
	
	public static int change(int amount, int[] coins) {
        if(amount == 0 || coins == null || coins.length == 0){
            return 0;
        }
        int[] res = new int[amount + 1];
        res[0] = 1;

        //�������Ǹ���̬�滮--�ܷ�����������ǰ���amout-count[x]��x����ͬ��Ӳ�ң��ļ���֮�������
         for (int coin : coins) {
             for (int x = coin; x < amount + 1; ++x) {
                 res[x] += res[x - coin];
             }
         }
         
        return res[amount];
    }
}
