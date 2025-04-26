# EIULOVE - Valentine

## Problem Statement

The Valentine's Day is coming. Mr. Beo wants to buy gifts for his girlfriend. Beo loves her so much that he wants to buy a special gift. However, Beo only has `K` VND in his pocket. He wants to use `K` Dong to buy gifts at the store. Help him choose the most expensive item he can afford.

### Input
- The first line gives integers `N` and `K`. `N` is the number of items in the store, and `K` is the amount Beo has.
- The `i`th line in the following `N` lines contains an integer which is the value of the `i`th item (`0 < N ≤ 10^5`, `0 < K < 10^18`, `v < 10^14`).

### Output
- Output the number `v` as the price of the selected gift. If Beo can't buy any gift, output `-1`.

### Example
**Input:**
```
5 100
10
20
30
40
50
```
**Output:**
```
50
```

## Explanation

### Problem Analysis
- Beo has `K` VND and wants to buy the most expensive item from a list of `N` items, where each item has a price `v`.
- The item Beo selects must have a price `v ≤ K`.
- If no item can be bought (i.e., all items cost more than `K`), output `-1`.
- Constraints:
  - `1 ≤ N ≤ 10^5`: The number of items is up to 100,000.
  - `0 < K < 10^18`: Beo's money can be very large.
  - `v < 10^14`: The price of each item is less than `10^14`.

### Approach
1. **Understand the Goal:**
   - Find the most expensive item Beo can afford, i.e., the maximum `v` such that `v ≤ K`.
   - If no such `v` exists, return `-1`.

2. **Key Insight:**
   - We need to iterate through the list of prices and find the maximum price that does not exceed `K`.
   - Since we only need the maximum affordable price, we can compare each price with `K` and keep track of the largest one that satisfies the condition.

3. **Steps:**
   - Read `N` and `K`.
   - For each of the `N` items, read its price `v`.
   - Track the maximum price `v` that is ≤ `K`.
   - If no price is ≤ `K`, output `-1`.

### Example Walkthrough
**Input:**
- `N=5`, `K=100`
- Prices: `10`, `20`, `30`, `40`, `50`

**Steps:**
- Initialize `maxPrice = -1` (default if no item can be bought).
- Compare each price with `K=100`:
  - `10 ≤ 100`: Update `maxPrice = 10`
  - `20 ≤ 100`: Update `maxPrice = 20`
  - `30 ≤ 100`: Update `maxPrice = 30`
  - `40 ≤ 100`: Update `maxPrice = 40`
  - `50 ≤ 100`: Update `maxPrice = 50`
- Final `maxPrice = 50`, which is ≤ `K`.

**Output:**
```
50
```

**Edge Case Example:**
- If `N=2`, `K=5`, and prices are `10`, `20`:
  - `10 > 5`, `20 > 5`
  - No price is ≤ `K`, so output `-1`.

### Solution Strategy
- **Step 1:** Read `N` and `K`.
- **Step 2:** Initialize a variable to track the maximum affordable price, starting with `-1`.
- **Step 3:** For each of the `N` prices, if the price is ≤ `K`, update the maximum affordable price.
- **Step 4:** Output the maximum affordable price (or `-1` if no item can be bought).

### Pseudocode
```plaintext
read N, K
maxPrice = -1
for i from 1 to N:
    read v
    if v ≤ K:
        maxPrice = max(maxPrice, v)
print maxPrice
```

### Time Complexity
- Reading and processing `N` items: `O(N)`
- Overall: `O(N)`

### Space Complexity
- `O(1)`: We only need a single variable to track the maximum price.

### Notes
- The constraints (`N ≤ 10^5`, `K < 10^18`, `v < 10^14`) ensure that the solution is feasible with a simple linear scan.
- Use `long` in Java to handle large values of `K` and `v` (up to `10^18` and `10^14`).
- Be cautious with edge cases, e.g., when `K` is smaller than all prices, or when `N=1`.