/**
 * @author Aurko
 *  You are given two non-empty linked lists representing two non-negative integers.
 *      The digits are stored in reverse order, and each of their nodes contains a single digit.
 *      Add the two numbers and return the sum as a linked list.
 *
 *      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
        ListNode dummy_head = new ListNode(0);  // Placeholder for final result
        ListNode l3 = dummy_head;                   // use l3 as a node to dump l1 + l2 into

        int carry_over = 0;  // use this to handle carry over when int > 10

        while ( l1 != null || l2 != null) {
            // If one node has more digits, account for the null and treat it as 0.
            int l1_value = (l1 != null) ? l1.val : 0;
            int l2_value = (l2 != null) ? l2.val : 0;

            int current_sum = l1_value + l2_value + carry_over; // Add up the digits plus the carryovers
            carry_over = current_sum/10;                        // use this to determine if a carryover exists
            int last_digit = current_sum % 10;                  // if a carryover exists get the last digit of the number

            ListNode new_node = new ListNode(last_digit);       // Create new node
            l3.next = new_node;                                 // Link L3's next to the new node

            // Set the pointer for the current node to the next node for each respective List
            if ( l1 != null ) l1 = l1.next;
            if ( l2 != null ) l2 = l2.next;
            l3 = l3.next;
        }

        if ( carry_over > 0 ) {
            ListNode new_node = new ListNode(carry_over);
            l3.next = new_node;
            l3 = l3.next;
        }
        return dummy_head.next;
    }
}