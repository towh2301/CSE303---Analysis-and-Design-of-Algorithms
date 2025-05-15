# EIEQUALS - Permutation

## Problem Statement

Given two integer arrays `a` and `b` of length `n` and an integer `k`, check if it is possible to turn array `a` into a permutation of array `b` by selecting a number from `a` and changing it by no more than `k` units.

### Input
- The first line contains two positive integers `n` and `k` (`1 ≤ n ≤ 10^5`, `1 ≤ k ≤ 10^9`).
- The second line contains `n` positive integers `a1, a2, ..., an` (`1 ≤ ai ≤ 10^9`).
- The third line contains `n` positive integers `b1, b2, ..., bn` (`1 ≤ bi ≤ 10^9`).

### Output
- Output "YES" if it is possible, otherwise output "NO".

### Example
**Input 1:**
```
3 1
2 3 4
2 2 3
```
**Output 1:**
```
NO
```

**Input 2:**
```
3 2
2 3 4
2 2 3
```
**Output 2:**
```
YES
```

## Explanation

### Problem Analysis
- We need to determine if we can transform array `a` into a permutation of array `b` by modifying at most one element in `a` by no more than `k` units.
- A permutation of `b` means the elements of the transformed `a` must match the elements of `b` in some order (i.e., `a` after transformation should have the same multiset of elements as `b`).
- We can change at most one element in `a` by adding or subtracting a value `x` where `|x| ≤ k`.

### Approach
1. **Understand the Transformation:**
   - We can pick one element in `a`, say `a[i]`, and change it to `a[i] + x` or `a[i] - x`, where `|x| ≤ k`.
   - After this change, the resulting array `a` must be a permutation of `b`.

2. **Key Insight:**
   - If we sort both arrays `a` and `b`, they should be nearly identical except for possibly one position (since we can modify at most one element).
   - Sort `a` and `b`. If they differ in more than one position, it’s impossible to make them equal with just one change.
   - If they differ in exactly one position, check if the difference at that position can be adjusted within `k` units.

3. **Steps:**
   - Sort copies of arrays `a` and `b`.
   - Compare the sorted arrays to find the positions where they differ.
   - If they differ in more than one position, return "NO".
   - If they differ in exactly one position, check if the difference can be covered by a change of at most `k` units.
   - If they are already identical, return "YES".

### Example Walkthrough
**Example 1:**
- Input: `n=3`, `k=1`, `a=[2, 3, 4]`, `b=[2, 2, 3]`
- Sorted `a`: `[2, 3, 4]`
- Sorted `b`: `[2, 2, 3]`
- Differences:
  - Position 1: `2 = 2` (same)
  - Position 2: `3 ≠ 2`
  - Position 3: `4 ≠ 3`
- There are 2 positions where they differ, so it’s impossible to make them equal with just one change.
- Output: `NO`

**Example 2:**
- Input: `n=3`, `k=2`, `a=[2, 3, 4]`, `b=[2, 2, 3]`
- Sorted `a`: `[2, 3, 4]`
- Sorted `b`: `[2, 2, 3]`
- Differences:
  - Position 1: `2 = 2` (same)
  - Position 2: `3 ≠ 2`
  - Position 3: `4 ≠ 3`
- There are 2 positions where they differ, but let’s consider the unsorted case for clarity:
  - Original `a`: `[2, 3, 4]`
  - Original `b`: `[2, 2, 3]`
  - Notice that `b` is a multiset `{2, 2, 3}`.
  - Try changing one element in `a`:
    - Change `a[2]` from `3` to `2`: `a` becomes `[2, 2, 4]`.
    - Change `a[3]` from `4` to `3`: `a` becomes `[2, 2, 3]`.
    - The change from `4` to `3` is `|4-3| = 1`, which is ≤ `k=2`.
- After changing `a[3]` to `3`, `a` becomes `[2, 3, 3]`, which can be permuted to match `b`’s multiset `{2, 2, 3}`.
- Output: `YES`

### Solution Strategy
- **Step 1:** Sort both arrays `a` and `b` to compare their multisets.
- **Step 2:** If the sorted arrays differ in more than one position, it’s impossible.
- **Step 3:** If they differ in one position, check if the difference is ≤ `k`.
- **Step 4:** If they are identical, no change is needed.

### Pseudocode
```plaintext
read n, k
read array a[n]
read array b[n]
sort a
sort b
count = 0
for i from 0 to n-1:
    if a[i] ≠ b[i]:
        count++
if count == 0:
    print "YES"
else if count == 1:
    for i from 0 to n-1:
        if a[i] ≠ b[i]:
            if abs(a[i] - b[i]) ≤ k:
                print "YES"
            else:
                print "NO"
            break
else:
    print "NO"
```

### Alternative Approach (More Precise)
- Since we need `a` to be a permutation of `b`, we should consider the multisets directly:
  - Compute the frequency of elements in `a` and `b`.
  - If the multisets differ by more than one element, it’s impossible.
  - Otherwise, check if the difference can be resolved with a change of ≤ `k`.

### Time Complexity
- Sorting: `O(n log n)`
- Comparison: `O(n)`
- Overall: `O(n log n)`

### Space Complexity
- `O(n)` for storing the arrays.

### Notes
- The constraints (`n ≤ 10^5`, `k ≤ 10^9`, `ai, bi ≤ 10^9`) ensure that the solution is feasible with sorting.
- Be cautious with edge cases, e.g., when `n=1`, or when arrays are already permutations of each other.