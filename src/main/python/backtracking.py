'''
given array arr. its represents grid. there are some obstacles.
you can go only 0. find possible path
'''


from typing import List


class Robot:

    def __init__(self) -> None:
        self.arr = [[0, 0, 1, 0, 0],
                    [1, 0, 0, 0, 1],
                    [1, 0, 1, 0, 1],
                    [1, 0, 1, 0, 0],
                    [0, 1, 0, 1, 0]]

        self.target = [4, 4]
        self.visited = set()
        self.dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    def findPath(self, i: int, j: int, path: List[str]) -> bool:
        # satisfied condition
        if i == self.target[0] and j == self.target[1]:
            return True
        # check boundaries and obstacles
        if i == len(self.arr) or i == -1 or j == -1 or j == len(self.arr) or self.arr[i][j] == 1:
            return False

        # try to every direction
        for dir in self.dirs:
            key = str(i+dir[0])+"-"+str(j+dir[1])
            if key not in self.visited:
                path.append([i+dir[0], j+dir[1]])
                self.visited.add(key)
                if self.findPath(i+dir[0], j+dir[1], path):
                    return True
                path.pop()
        return False


robot = Robot()
path = [[3, 1]]
r = robot.findPath(path[0][0], path[0][1], path)
print(path)


