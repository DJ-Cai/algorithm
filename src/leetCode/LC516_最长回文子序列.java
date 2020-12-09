package leetCode;

public class LC516_����������� {
	/**
	 * 516. �����������
	����һ���ַ��� s ���ҵ�������Ļ��������У������ظ����еĳ��ȡ����Լ��� s ����󳤶�Ϊ 1000 ��
	ʾ�� 1:
	����:
	"bbbab"
	���:
	4
	һ�����ܵ������������Ϊ "bbbb"��
	
	��ȷ�����к��Ӵ�����������������в�Ҫ����������������Ҫ��
	 */
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
	}
	
	
	public static int longestPalindromeSubseq(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		//����˼·��˵���һ��Ĵ������Դ��м�����߿�ʼ���������ǻ��ġ������С�������Ҫ����������ǿ��Ƕ�̬�滮
		//���������Ƕ��壬ij��dptable�����У��ֱ����ʲô��˫ָ�룬i�����ұ�����j���ҵ������
		//���壺res��װ�ŵ�ǰijָ��������Ӵ������ܳɵ������������ --- �����ζ�ţ��𰸻����table�����Ͻ�
		int[][] res = new int[s.length()][s.length()];
		//��ʼ�������������Ķ��壬����i=j��ʱ����ζ���Ӵ�ֻ��һ���ַ�������ֵӦ��Ϊ1�� 
		//����һ�����ƣ�i�����ұ�����j���ҵ����������ʵ������ν�ģ�ֻ��˵�����ظ���������ǿ���ȥ��һ�룬��i > j ����  j > i ��ʱ��ȡ0��ע�����j>iȡ0�Ļ�����Ӧ�������½ǣ�
		//Ĭ�ϳ�ʼ��Ϊ0���������ﲻ�ò���
		for(int i = 0 ; i < res.length ; i++) {
			res[i][i] = 1;
		}
		//��Ȼ�������Ͻǣ�����Ӧ��������Ͻǣ����Ǵ������濪ʼ���������dp table
		for(int i = s.length() - 2 ; i >= 0 ; i--) {
			for(int j = i + 1; j < s.length() ; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					res[i][j] = res[i+1][j-1] + 2;
				}else {
					res[i][j] = Math.max(res[i][j-1], res[i+1][j]);
				}
			}
		}
		return res[0][s.length()-1];
    }
	
}
