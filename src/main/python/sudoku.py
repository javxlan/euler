from typing import List


class Sudoku:

    def __init__(self, board=[[]]) -> None:

        self.board = board

    def solve(self) -> bool:
        i, j = self.next()
        if i == -1 and j == -1:
            for row in self.board:
                print(row)
            return True

        numbers = self.getNumbers(i, j)

        if numbers is None:
            return False

        for number in numbers:
            self.board[i][j] = number
            if self.solve():
                return True
            self.board[i][j] = "."
        return False

    def is_valid(self, row: int, col: int, val: str) -> bool:

        # check row
        if val in self.board[row]:
            return False

        # check col
        col_vals = [self.board[i][col] for i in range(len(self.board))]
        if val in col_vals:
            return False

        # check box
        row_start = (row//3) * 3
        col_start = (col//3) * 3

        for r in range(row_start, row_start+3):
            for c in range(col_start, col_start+3):
                if self.board[r][c] == val:
                    return False
        return True

    def getNumbers(self, i: int, j: int) -> List[str]:
        ls = []
        for num in range(1, len(self.board)+1):
            if self.is_valid(i, j, str(num)):
                ls.append(str(num))
        return ls

    def next(self):
        for i in range(len(self.board)):
            for j in range(len(self.board[i])):
                if self.board[i][j] == ".":
                    return i, j
        return -1, -1


board = [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."], [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"], ["4", ".", ".", "8",
                                                                                                                                                                                                      ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"], [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"], [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
sudoku = Sudoku(board)
sudoku.solve()
