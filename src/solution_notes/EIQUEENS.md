# 8 Queens Puzzle Solution Note

## Problem Description

The 8 Queens puzzle involves placing 8 queens on an 8x8 chessboard such that no two queens can attack each other. This
means no two queens can share the same row, column, or diagonal. The input is an 8x8 grid where '*' represents a queen
and '.' represents an empty space. We need to determine if the given board is a valid solution.

## Input Board

The board provided is:

```
*.......
..*.....
....*...
......*.
.*......
.......*
.....*..
...*....
```

## Solution Approach

### 1. Read the Input

- The input is 8 lines, each with 8 characters ('*' for queens, '.' for empty spaces).
- Treat it as a list of 8 strings, one for each row.
- Identify queen positions: For each row `i`, find the column `j` where `board[i][j] = '*'`.

Queen positions on this board:

- (0,0), (1,2), (2,4), (3,6), (4,1), (5,7), (6,5), (7,3).

### 2. Validate the Board

#### Check Queen Count

- Count the number of '*' characters.
- There are 8 queens, which matches the requirement.

#### Check Rows

- Each row must have exactly one queen.
- Since we found one queen per row (positions listed above), this condition is satisfied.

#### Check Columns

- Queens cannot share the same column.
- Column indices of queens: 0, 2, 4, 6, 1, 7, 5, 3.
- All are unique, so this condition is satisfied.

#### Check Diagonals

Queens cannot share diagonals. We check two types of diagonals:

- **Main Diagonal (Top-Left to Bottom-Right)**:
    - For each queen at (row, col), compute `row - col`.
    - Positions with the same `row - col` value are on the same main diagonal.
    - Values:
        - (0,0): 0 - 0 = 0
        - (1,2): 1 - 2 = -1
        - (2,4): 2 - 4 = -2
        - (3,6): 3 - 6 = -3
        - (4,1): 4 - 1 = 3
        - (5,7): 5 - 7 = -2
        - (6,5): 6 - 5 = 1
        - (7,3): 7 - 3 = 4
    - List: 0, -1, -2, -3, 3, -2, 1, 4.
    - `-2` repeats (from (2,4) and (5,7)), so these queens share a main diagonal, making the board invalid.

- **Anti-Diagonal (Bottom-Left to Top-Right)**:
    - For each queen at (row, col), compute `row + col`.
    - Positions with the same `row + col` value are on the same anti-diagonal.
    - Values:
        - (0,0): 0 + 0 = 0
        - (1,2): 1 + 2 = 3
        - (2,4): 2 + 4 = 6
        - (3,6): 3 + 6 = 9
        - (4,1): 4 + 1 = 5
        - (5,7): 5 + 7 = 12
        - (6,5): 6 + 5 = 11
        - (7,3): 7 + 3 = 10
    - List: 0, 3, 6, 9, 5, 12, 11, 10.
    - All values are unique, so no conflict here.

### 3. Output

- Since there’s a conflict on the main diagonal (`-2` repeats), the board is not a valid solution.
- Output: **invalid**.

## Conclusion

The given board does not satisfy the 8 Queens puzzle rules because two queens (at positions (2,4) and (5,7)) share the
same main diagonal. A valid solution requires that no two queens share a row, column, or diagonal.