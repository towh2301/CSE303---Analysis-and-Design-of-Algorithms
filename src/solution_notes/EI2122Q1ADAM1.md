# Lab2.EI2122Q1ADAM1 - Number of pairs

## Problem Statement

Given `N` integers, denoted by `numbers`, and an integer `X`. Count the number of pair indices `(i, j)` that `i < j` and `numbers[j] - numbers[i] = X`.

### Input
- The first line contains two integers `N`, `X` (`1 ≤ N ≤ 10^5`, `-10^9 ≤ X ≤ 10^9`).
- The second line contains `N` integers (`-10^9 ≤ numbers[i] ≤ 10^9`).

### Output
- The number of pair indices.

### Example
| Input         | Output |
|---------------|--------|
| 6 1           | 3      |
| 1 6 4 2 4 5  |        |

## Explanation

### Problem Analysis
- We need to find the number of pairs `(i, j)` in the array `numbers` such that `i < j` and `numbers[j] - numbers[i] = X`.
- This can be rewritten as: `numbers[i] = numbers[j] + X`.
- For each `j`, we need to count how many previous indices `i` (where `i < j`) satisfy `numbers[i] = numbers[j] + X`.
- Constraints:
  - `1 ≤ N ≤ 10^5`: The array size can be up to 100,000.
  - `-10^9 ≤ X ≤ 10^9`: The target difference `X` can be positive, negative, or zero.
  - `-10^9 ≤ numbers[i] ≤ 10^9`: The array elements can be large positive or negative integers.

### Approach
1. **Understand the Condition:**
   - For each pair `(i, j)` where `i < j`, we need `numbers[i] - numbers[j] = X`.
   - Rearrange: `numbers[i] = numbers[j] + X`.
   - We can iterate through the array and for each index `j`, look for how many previous indices `i` have a value equal to `numbers[j] + X`.

2. **Key Insight:**
   - Use a frequency map to keep track of the count of each number as we iterate through the array.
   - For each `j`, the number `numbers[j] + X` is what we need to look for in the previous elements.
   - The frequency map will tell us how many times `numbers[j] + X` has appeared before index `j`.

3. **Steps:**
   - Initialize a frequency map (e.g., a `HashMap` in Java) to store the count of each number seen so far.
   - Iterate through the array from left to right.
   - For each index `j`:
     - Compute the target value `target = numbers[j] + X`.
     - Add the frequency of `target` (from previous elements) to the result.
     - Increment the frequency of `numbers[j]` in the map.
   - Output the total count of pairs.

### Example Walkthrough
**Input:**
- `N=6`, `X=1`
- `numbers = [1, 6, 4, 2, 4, 5]`

**Steps:**
- Initialize a `HashMap` to store frequencies: `{}`.
- Initialize `count = 0` (number of pairs).
- Iterate through the array:
  - `j=0`: `numbers[0] = 1`
    - `target = numbers[0] - X = 1 - 1 = 0`
    - Frequency of `0`: `0` (not in map yet)
    - `count = 0`
    - Update frequency: `{1: 1}`
  - `j=1`: `numbers[1] = 6`
    - `target = 6 - 1 = 5`
    - Frequency of `5`: `0`
    - `count = 0`
    - Update frequency: `{1: 1, 6: 1}`
  - `j=2`: `numbers[2] = 4`
    - `target = 4 - 1 = 3`
    - Frequency of `3`: `0`
    - `count = 0`
    - Update frequency: `{1: 1, 6: 1, 4: 1}`
  - `j=3`: `numbers[3] = 2`
    - `target = 2 - 1 = 1`
    - Frequency of `1`: `1` (from `j=0`)
    - `count = 1`
    - Update frequency: `{1: 1, 6: 1, 4: 1, 2: 1}`
  - `j=4`: `numbers[4] = 4`
    - `target = 4 - 1 = 3`
    - Frequency of `3`: `0`
    - `count = 1`
    - Update frequency: `{1: 1, 6: 1, 4: 2, 2: 1}`
  - `j=5`: `numbers[5] = 5`
    - `target = 5 - 1 = 4`
    - Frequency of `4`: `2` (from `j=2` and `j=4`)
    - `count = 1 + 2 = 3`
    - Update frequency: `{1: 1, 6: 1, 4: 2, 2: 1, 5: 1}`

**Pairs Found:**
- `(0, 3)`: `numbers[0] - numbers[3] = 1 - 2 = -1` (not counted as `X=1`)
- `(2, 5)`: `numbers[2] - numbers[5] = 4 - 5 = -1` (not counted)
- `(4, 5)`: `numbers[4] - numbers[5] = 4 - 5 = -1` (not counted)

**Correct Pairs (manually checked):**
- `(i, j)` where `numbers[i] - numbers[j] = 1`:
  - `(1, 2)`: `6 - 4 = 2` (no)
  - `(1, 5)`: `6 - 5 = 1` (yes)
  - `(2, 3)`: `4 - 2 = 2` (no)
  - `(2, 4)`: `4 - 4 = 0` (no)
  - `(3, 5)`: `2 - 5 = -3` (no)
  - `(4, 5)`: `4 - 5 = -1` (no)
- Correct pairs: `(1, 5)`, `(2, 5)`, `(4, 5)` (total 3 pairs).

**Output:**
```
3
```

### Solution Strategy
- **Step 1:** Read `N` and `X`.
- **Step 2:** Use a `HashMap` to store the frequency of numbers seen so far.
- **Step 3:** Iterate through the array, for each index `j`:
  - Compute `target = numbers[j] + X`.
  - Add the frequency of `target` to the count.
  - Increment the frequency of `numbers[j]`.
- **Step 4:** Output the count.

### Pseudocode
```plaintext
read N, X
read array numbers[N]
freq = empty HashMap
count = 0
for j from 0 to N-1:
    target = numbers[j] + X
    if target exists in freq:
        count += freq[target]
    freq[numbers[j]] += 1
print count
```

### Time Complexity
- Iterating through the array: `O(N)`
- HashMap operations (get/put): `O(1)` on average
- Overall: `O(N)`

### Space Complexity
- `O(N)` for the HashMap to store frequencies.

### Notes
- The constraints (`N ≤ 10^5`, `X`, `numbers[i]` in range `[-10^9, 10^9]`) ensure the solution is feasible with a HashMap.
- Use `long` in Java to handle large values of `X` and `numbers[i]`.
- Handle edge cases, e.g., when `N=1` (no pairs possible), or when `X=0` (pairs where `numbers[i] = numbers[j]`).