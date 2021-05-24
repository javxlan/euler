'''
Given an integer n, return the number of structurally unique BST's
(binary search trees) which has exactly n nodes of unique values from 1 to n.
'''


class Solution:
    def numTrees(self, n: int) -> int:
        answer = 0
        for i in range(1, n+1):
            answer += self.total_ways_in(i)
        return answer

    def total_ways_in(self, number: int) -> int:
        return number


s = Solution()
print(s.numTrees(3))

'''
1 -> 1 
2- > 2 
3- > 3

'''
