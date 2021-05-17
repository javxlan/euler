class Sudoku:

    def __init__(self, board=[[]]) -> None:
        
        self.board = board
        self.rows = []
        self.cols = []

        for row in range(len(self.board)):
            temp = set()
            for col in range(len(self.board)):
                if self.board[row][col] != 0:
                    temp.add(self.board[row][col])
            self.rows.append(temp)            

        for col in range(len(self.board)):
            temp = set()
            for row in range(len(self.board)):
                if self.board[row][col] != 0:
                    temp.add(self.board[row][col])
            self.cols.append(temp)            


    def solve(self) -> None:
        i, j = self.next()        
        if i==-1 and j==-1:    
            for row in self.board:
                print(row)        
            return
        
        numbers = self.getNumbers(i,j)        

        if numbers is None:
            return

        for number in numbers:
            #print(number)
            temp = self.board[i][j]
            self.board[i][j] = number
            #self.rows[i]            
            self.solve()
            self.board[i][j] = temp

        return

        # print(self.board)

    def getNumbers(self, i: int, j: int):
        ls = []
        for num in range(1, len(self.board)+1):                        
            if num not in self.rows[i] and num not in self.cols[j]:
                ls.append(num)                 
        return ls

    def next(self):
        for i in range(len(self.board)):
            for j in range(len(self.board[i])):
                if self.board[i][j] == 0:
                    return i, j
        return -1, -1


# board = [[5,3,0,0,7,0,0,0,0],
#          [6,0,0,1,9,5,0,0,0],
#          [0,9,8,0,0,0,0,6,0],
#          [8,0,0,0,6,0,0,0,3],
#          [4,0,0,8,0,3,0,0,1],
#          [7,0,0,0,2,0,0,0,6],
#          [0,6,0,0,0,0,2,8,0],
#          [0,0,0,4,1,9,0,0,5],
#          [0,0,0,0,8,0,0,7,9]]

board = [[0,0,0,3],
         [0,1,0,4,],
         [4,2,3,1,],
         [1,1,4,2,]]         


sudoku = Sudoku(board)

sudoku.solve()

#print(sudoku.board)
