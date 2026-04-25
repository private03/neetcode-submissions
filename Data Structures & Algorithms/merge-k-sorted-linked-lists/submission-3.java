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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        {
            return null;
        }

        return divide(lists, 0, lists.length - 1);

    }

    public ListNode divide(ListNode[] lists, int s, int e)
    {
        if(s > e)
        {
            return null;
        }

        if (s == e)
        {
            return lists[s];
        }

        int m = s + (e - s) / 2;

        ListNode one = divide(lists, s, m);
        ListNode two = divide(lists, m + 1, e);
        return merge(one, two);

    }

    public ListNode merge(ListNode one, ListNode two)
    {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(one != null && two != null)
        {
            if(one.val < two.val)
            {
                curr.next = one;
                one = one.next;
            }
            else
            {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        if(one != null)
        {
            curr.next = one;
        }

        if(two != null)
        {
            curr.next = two;
        }

        return dummy.next;

    }

}
