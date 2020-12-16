package leetCode;

//2. �������
//�������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
//��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
//�����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
//ʾ����
//���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
//�����7 -> 0 -> 8
//ԭ��342 + 465 = 807
public class LC2_������� {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1, l2);
		while(res != null) {
			if(res.next != null) {
				System.out.print(res.val + " -> ");
			}
			else {
				System.out.println(res.val);
			}
			res = res.next;
		}
	}
	
	//��ʵҲ��˳���������ӵ���Ŀ������������
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //�ܽ��
        ListNode res = new ListNode(-1);
        //һλλ�ļ�¼���
        ListNode cur = res;
        //��¼��λ
        int ca = 0;
        while(l1 != null || l2 != null){
        	//��¼��ǰ�ڵ����ֵ����������Ѿ������ˣ�ֵ����0
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            //���λ�õ���ֵ������  v1��ֵ  +  v2��ֵ  +  ǰ���λ��������ֵ
            int sum = v1 + v2 + ca;
            //����ֻ������λ���ģ������Ĳ��ָ��½�λ���ŵ��´μ���sum��
            cur.next = new ListNode(sum % 10);
            ca = sum / 10;
            cur = cur.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        //������������߹��ˣ�����λ���У�֤����Ҫ��չһλ
        if(ca > 0){
            cur.next = new ListNode(ca);
        }
        //res��һ���ڵ���Ϊ�ڱ����򻯴���
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}