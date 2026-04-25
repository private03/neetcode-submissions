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
        return divide(lists, 0,  lists.length - 1);

    }

    public ListNode divide(ListNode[] lists, int l, int r)
    {
        if(l > r)
        {
            return null;
        }

        if(l == r)
        {
            return lists[l];
        }

        int m = l + (r - l) / 2;

        ListNode one = divide(lists, l, m);
        ListNode two = divide(lists, m + 1 , r);
        return conquer(one, two);

    }

    public ListNode conquer(ListNode one,  ListNode two)
    {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(one != null && two != null)
        {
            if(one.val <= two.val)
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
