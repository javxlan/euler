from typing import List


class Solution:    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans = []
        temp = []        
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
                temp.pop()
        return False


candidates = [2,2,3]
target = 7

s = Solution()
# s.combinationSum(candidates, target)
result  =  s.combinationSum(candidates, target)
print(result)
