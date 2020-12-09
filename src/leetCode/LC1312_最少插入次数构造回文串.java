package leetCode;

public class LC1312_���ٲ������������Ĵ� {
	/**
	 * 1312. ���ַ�����Ϊ���Ĵ������ٲ������
	����һ���ַ��� s ��ÿһ�β����㶼�������ַ���������λ�ò��������ַ���
	���㷵���� s ��Ϊ���Ĵ��� ���ٲ������� ��
	�����Ĵ����������ͷ�������ͬ���ַ�����
	
	ʾ�� 1��
	���룺s = "zzazz"
	�����0
	���ͣ��ַ��� "zzazz" �Ѿ��ǻ��Ĵ��ˣ����Բ���Ҫ���κβ��������
	 */
	//�������������һ����˼·�����ﲻ����ע����
	public static void main(String[] args) {
		System.out.println(minInsertions("abcd"));
	}
	
    public static int minInsertions(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[][] res = new int[s.length()][s.length()];
        for(int i = s.length() - 2 ; i >= 0 ;  i--){
            for(int j = i + 1 ; j < s.length() ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    res[i][j] = res[i+1][j-1];
                }else{
                    res[i][j] = Math.min(res[i+1][j] + 1 , res[i][j-1] + 1);
                }
            }
        }
        return res[0][res[0].length - 1];
    }
}
