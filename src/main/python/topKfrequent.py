from typing import List
from heapq import heappop, heappush, heappushpop


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0)+1

        max_heap = []
        for fre in freq:
            heappush(max_heap, freq.get(fre))
            if len(max_heap)-1 == k:
                heappop(max_heap)

        ans = []
        for fre in freq:
            if freq.get(fre) in max_heap:
                ans.append(fre)
        return ans


nums = [1, 1, 1, 2, 2, 3]
k = 2
s = Solution()
print(s.topKFrequent(nums, k))
