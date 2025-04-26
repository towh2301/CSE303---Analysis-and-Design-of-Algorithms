# EI2122Q1ADAM2 - Matching

## Problem Statement

Given the height of `N` men and `M` women, we need to form `X` pairs of one man and one woman. The height `H` of a pair is defined as `H = max(|pair.manHeight - pair.womanHeight|, X)`. What is the minimum possible value of `H`?

### Input
- The first line contains three integers `N`, `M`, `X` (`1 ≤ N, M ≤ 10^5`).
- The second line contains `N` integers indicating the height of the men.
- The third line contains `M` integers indicating the height of the women.

### Output
- The minimum possible value of `H`.

### Note
- 50% test cases: `X = N = M`

### Example
| Input                 | Output |
|-----------------------|--------|
| 5 6 3                 | 3      |
| 150 160 170 184 156   |        |
| 152 155 159 168 190   |        |
| 5 5 5                 | 12     |
| 150 180 165 184 156   |        |
| 152 168 175 159 168   |        |

## Explanation

### Problem Analysis
- We need to form `X` pairs, each consisting of one man and one woman.
- For each pair, the "height" `H` is defined as `H = max(|manHeight - womanHeight|, X)`.
- We need to minimize the maximum `H` across all `X` pairs.
- Constraints:
  - `1 ≤ N, M ≤ 10^5`: The number of men and women can be up to 100,000.
  - Heights are integers (assumed to be reasonable, e.g., positive and within a practical range).
- Special case: For 50% of test cases, `X = N = M`, meaning we pair all men and women.

### Approach
1. **Understand the Goal:**
   - We need to select `X` men and `X` women to form `X` pairs.
   - For each pair `(man, woman)`, compute `H = max(|manHeight - womanHeight|, X)`.
   - Minimize the maximum `H` across all `X` pairs.

2. **Key Insight:**
   - The value of `H` for a pair is at least `X` (since `H = max(|difference|, X)`).
   - We want to minimize the maximum `H`, so we should try to make the absolute differences `|manHeight - womanHeight|` as small as possible, but `H` will never be less than `X`.
   - Sort both arrays (men’s heights and women’s heights) and pair men and women in a way that minimizes the maximum difference.

3. **Binary Search on `H`:**
   - Since we need to minimize `H`, we can use binary search to find the smallest possible `H`.
   - For a candidate `H`, check if we can form `X` pairs such that for each pair, `max(|manHeight - womanHeight|, X) ≤ H`.
   - Since `H ≥ X`, this simplifies to checking if `|manHeight - womanHeight| ≤ H` for each pair (because if `|manHeight - womanHeight| ≤ H`, then `max(|manHeight - womanHeight|, X) ≤ H` as long as `X ≤ H`).

4. **Steps:**
   - Sort the men’s heights and women’s heights.
   - Binary search on `H` (the answer):
     - For each candidate `H`, check if we can form `X` pairs where `|manHeight - womanHeight| ≤ H`.
     - Use two pointers or a greedy approach to match men and women:
       - Iterate through the sorted men’s heights.
       - For each man, find a woman whose height is within `H` of the man’s height (i.e., `|manHeight - womanHeight| ≤ H`).
       - If we can form `X` pairs, `H` is feasible; otherwise, it’s not.
   - The smallest feasible `H` is the answer.

### Example Walkthrough
**Example 1:**
- Input: `N=5`, `M=6`, `X=3`, `men=[150, 160, 170, 184, 156]`, `women=[152, 155, 159, 168, 190]`
- Sorted `men`: `[150, 156, 160, 170, 184]`
- Sorted `women`: `[152, 155, 159, 168, 190]`
- Binary search on `H`:
  - `H ≥ X = 3`.
  - Try `H = 3`:
    - For each man, find a woman such that `|manHeight - womanHeight| ≤ 3`.
    - Man `150`: Women `152, 155` (differences `2, 5`) → Pair with `152`.
    - Man `156`: Women `155, 159` (differences `1, 3`) → Pair with `155`.
    - Man `160`: Woman `159` (difference `1`) → Pair with `159`.
    - We formed 3 pairs, and all differences are ≤ `3`.
    - `H = 3` is feasible.
  - Try `H < 3`: Not possible since `H ≥ X`.
- Output: `3`

**Example 2:**
- Input: `N=5`, `M=5`, `X=5`, `men=[150, 180, 165, 184, 156]`, `women=[152, 168, 175, 159, 168]`
- Sorted `men`: `[150, 156, 165, 180, 184]`
- Sorted `women`: `[152, 159, 168, 168, 175]`
- Binary search on `H`:
  - `H ≥ X = 5`.
  - Try `H = 12`:
    - Man `150`: Woman `152` (difference `2`)
    - Man `156`: Woman `159` (difference `3`)
    - Man `165`: Woman `168` (difference `3`)
    - Man `180`: Woman `168` (difference `12`)
    - Man `184`: Woman `175` (difference `9`)
    - All differences are ≤ `12`, and we paired all 5.
  - Try `H = 11`:
    - Man `180` cannot be paired with difference ≤ `11` (closest is `168`, difference `12`).
    - Not possible.
  - Minimum `H = 12`.
- Output: `12`

### Solution Strategy
- **Step 1:** Read `N`, `M`, `X`, and the arrays of heights.
- **Step 2:** Sort both arrays.
- **Step 3:** Binary search on `H`:
  - For each `H`, check if we can form `X` pairs with `|manHeight - womanHeight| ≤ H`.
  - Use two pointers to greedily match men and women.
- **Step 4:** Output the smallest feasible `H`.

### Pseudocode
```plaintext
read N, M, X
read array men[N]
read array women[M]
sort men
sort women
lo = X, hi = max difference possible
while lo < hi:
    mid = (lo + hi) / 2
    if canFormXPairs(mid):
        hi = mid
    else:
        lo = mid + 1
print lo

function canFormXPairs(H):
    count = 0
    j = 0
    for i from 0 to N-1:
        while j < M and abs(men[i] - women[j]) > H:
            j++
        if j < M:
            count++
            j++
    return count ≥ X
```

### Time Complexity
- Sorting: `O(N log N + M log M)`
- Binary search: `O(log(maxHeight))`
- For each `H`, checking feasibility: `O(N + M)`
- Overall: `O((N + M) log(maxHeight) + N log N + M log M)`

### Space Complexity
- `O(N + M)` for storing the arrays.

### Notes
- The constraints (`N, M ≤ 10^5`) ensure the solution is feasible.
- Use `long` in Java to handle large height differences.
- The special case `X = N = M` simplifies to pairing all men and women.