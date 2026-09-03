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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1 == ptr2) {
                return true;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if (ptr2 != null) {
                ptr2 = ptr2.next;
            }
        }
        return false;
    }
}
