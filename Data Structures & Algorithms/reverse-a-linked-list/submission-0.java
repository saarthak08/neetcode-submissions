/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currNext = head.next;
        head.next = null;
        ListNode curr = head;
        while (currNext != null) {
            ListNode temp = currNext.next;
            currNext.next = curr;
            curr = currNext;
            currNext = temp;
        }
        return curr;
    }
}
