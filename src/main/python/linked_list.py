from typing import Any


class ListNode:
    def __init__(self, val: Any) -> None:
        self.val = val
        self.next = None


class Solution:
    def reverse_list(self, head: ListNode) -> ListNode:
        prev = None
        next = None
        current = head
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next
        return prev


head = ListNode(None)
node = head

for i in range(1, 6):
    node.next = ListNode(i)
    node = node.next

s = Solution()
reversed = s.reverse_list(head.next)

while reversed is not None:
    print(reversed.val)
    reversed = reversed.next
