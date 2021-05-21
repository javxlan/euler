'''
Find a shortest path. Given 8x8 chess board with source and destination positions.
'''
import queue
from typing import List


class Point:

    def __init__(self, x: int, y: int, path: str) -> None:
        self.x = x
        self.y = y
        self.path = path

    def __str__(self) -> str:
        return str(self.x)+","+str(self.y)


class Knights:

    def find_shortest_path(self, source: Point, destination: Point) -> str:
        answer = ""
        if source.x == destination.x and source.y == destination.y:
            return answer

        directions = [[-2, 1], [-1, 2], [1, 2],
                      [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1]]
        visited = set()
        q = queue.Queue()
        q.put(source)

        while q:
            current = q.get()
            if current.x == destination.x and current.y == destination.y:
                return current.path

            for dir in directions:
                cur_path = current.path + \
                    str(current.x+dir[0]) + ":" + str(current.y+dir[1])+","
                next = Point(current.x+dir[0], current.y+dir[1], cur_path)

                if self.is_safe(next.x, next.y):
                    if next not in visited:
                        visited.add(next)
                        q.put(next)
        return answer

    def is_safe(self, row: int, col: int) -> bool:
        return row in range(0, 8) and col in range(0, 8)

    def print(self, path: str) -> None:
        char = {1: 'A', 2: 'B', 3: 'C', 4: 'D', 5: 'D', 6: 'E', 7: 'F', 8: 'G'}
        num = {1: 8, 2: 7, 3: 6, 4: 5, 5: 4, 6: 3, 7: 2, 8: 1}
        points = path.split(",")
        for point in points:
            print("{}{} ".format(char[int(point[0:1])], num[int(point[-1:])]))


k = Knights()
source = Point(1, 1, "")
destination = Point(7, 5, "")
path = k.find_shortest_path(source, destination)
k.print(path[:-1])
