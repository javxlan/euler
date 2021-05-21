'''
Find a shortest path. Given 8x8 chess board with source and destination positions.
'''
import queue
from typing import List

class Point:                
    
    def __init__(self,x:int,y:int) -> None:                
        self.x =x
        self.y =y        
        self.path = []
    
    def addChild(self,child):
        self.path.append(child)


class Knights:

    def find_shortest_path(self,source: Point,destination: Point) -> str:
        answer = ""
        if source.x==destination.x and source.y== destination.y:
            return answer
        
        directions = [[0,-1],[1,0],[0,1],[-1,0]]
        visited = set()
        q = queue.Queue()        
        q.put(source)   

        while(not q.empty()):
            current = q.get()                                          
            for dir in directions:                                
                next = Point(current.x+dir[0],current.y+dir[1])   
                next.addChild(next)                                             
                if next.x ==destination.x and next.y == destination.y:
                    return next.path
                if self.is_safe(next.x,next.y):                    
                    if next not in visited:
                        visited.add(next)
                        q.put(next)
        return answer

    def is_safe(self,row:int , col:int)->bool:
        return row in range(0,8) and col in range(0,8)


        
    


k = Knights()
source  = Point(0,0)
destination  = Point(1,4)
print(k.find_shortest_path(source,destination))


