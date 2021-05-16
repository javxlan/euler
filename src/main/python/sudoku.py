class Sudoku:

    def __init__(self, board=[[]]) -> None:
        self.board = board
        self.rows = {}
        self.cols = {}
        self.rows = {}

    def solve(self) -> None:
        i, j = self.next()

        # print(self.board)

    def getNumber(self, i: int, j: int):
        for num in len(1, len(self.board)+1):
            if num not in self.rows:
                return num
        return -1

    def next(self):
        for i in len(self.board):
            for j in len(self.board[i]):
                if self.board[i][j] == 0:
                    return i, j
        return -1, -1


board = [[3, 0, 4, 0],
         [0, 1, 0, 2],
         [0, 4, 0, 3],
         [2, 0, 1, 0]]

sudoku = Sudoku(board)

# sudoku.solve()
