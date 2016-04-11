package muyanmoyang.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author hadoop
 * 
 */
public class AddTwoNumbers_2 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode node = new ListNode(8);
		l1.next = node;
		ListNode l2 = new ListNode(0);
		AddTwoNumbers_2 a = new AddTwoNumbers_2();
		ListNode tmp = a.addTwoNumbers(l1, l2);
		while (tmp != null) {
			System.out.print(tmp.val + "¡¢");
			tmp = tmp.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// ListNode result = new ListNode(0) ;
		List<Integer> list = new LinkedList<Integer>();
		int remain = 0;
		while (l1 != null || l2 != null) {
			ListNode tmp1 = l1;
			ListNode tmp2 = l2;
			ListNode node;
			int sum1 = 0;
			sum1 = tmp1.val + tmp2.val + remain;
			if (sum1 >= 10) {
				remain = 1;
				list.add(sum1 - 10);
			} else {
				remain = 0;
				list.add(sum1);
			}
			if (l1.next != null || l2.next != null) {
				if (l1.next != null && l2.next == null) {
					l1 = l1.next;
					l2 = new ListNode(0);
				} else {
					if (l2.next != null && l1.next == null) {
						l2 = l2.next;
						l1 = new ListNode(0);
						;
					} else {
						l1 = l1.next;
						l2 = l2.next;
					}
				}
			} else {
				if (remain != 0) {
					list.add(remain);
				}
				break;
			}
		}
		ListNode result = new ListNode(list.get(0));
		ListNode r = result;
		for (int i = 1; i < list.size(); i++) {
			ListNode node = new ListNode(list.get(i));
			r.next = node;
			r = r.next;
		}
		return result;
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
