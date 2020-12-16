package leetCode;

//2. 两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//示例：
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class LC2_两数相加 {
	
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
	
	//其实也有顺序的链表相加的题目，这题是逆序
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //总结果
        ListNode res = new ListNode(-1);
        //一位位的记录结果
        ListNode cur = res;
        //记录进位
        int ca = 0;
        while(l1 != null || l2 != null){
        	//记录当前节点的数值，如果链表已经结束了，值就是0
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            //这个位置的数值，就是  v1的值  +  v2的值  +  前面进位进上来的值
            int sum = v1 + v2 + ca;
            //但是只能留个位数的，超过的部分更新进位，放到下次计算sum中
            cur.next = new ListNode(sum % 10);
            ca = sum / 10;
            cur = cur.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        //如果两条链表都走光了，但进位还有，证明需要拓展一位
        if(ca > 0){
            cur.next = new ListNode(ca);
        }
        //res第一个节点作为哨兵，简化代码
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}