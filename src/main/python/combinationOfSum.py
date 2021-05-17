from typing import List


class Solution:
    # def __init__(self) -> None:
    #     self.ans = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        temp = []
        self.ans = []
        candidates.sort()
        self.solve(candidates, target, candidates[0], temp)
        return self.ans

    def solve(self, candidates: List[int], target: int, can: int, temp: List[List[int]]) -> bool:
        if target == 0:
            return True
        if target < 0:
            return False

        for candidate in candidates:
            if candidate >= can:
                temp.append(candidate)
                if self.solve(candidates, target-candidate, candidate, temp):
                    self.ans.append(temp)
                    # print(temp)
                temp.pop()
        return False


candidates = [2, 3, 5]
target = 8

s = Solution()
# s.combinationSum(candidates, target)
print(s.combinationSum(candidates, target))
