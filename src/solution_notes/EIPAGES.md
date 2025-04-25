# EIPAGES - Page Numbers Solution Note

## Problem Description
The task is to format a list of unique page numbers into a concise string. Use "-" for sequences of 3 or more consecutive pages (e.g., 141, 142, 143 becomes "141-143"), and "," to separate individual pages or sequences of less than 3 consecutive pages (e.g., 174, 175 becomes "174,175"). The page numbers must be listed in ascending order.

### Input
- First line: An integer \( N \) (1 ≤ \( N \) ≤ 1000), the number of pages.
- Second line: \( N \) unique integers representing page numbers.

### Output
- A string listing the page numbers in ascending order, following the formatting rules.

### Example
- **Input**:  
  \( N = 6 \)  
  Page numbers: 180, 141, 174, 143, 142, 175  
- **Output**:  
  "141-143,174,175,180"

## Solution Approach

### 1. Read and Sort the Input
- Read \( N \) (number of pages).
- Read the \( N \) page numbers into a list.
- Sort the list in ascending order (smallest to largest).  
  For the example:  
  - Input pages: [180, 141, 174, 143, 142, 175]  
  - Sorted: [141, 142, 143, 174, 175, 180]

### 2. Identify Consecutive Sequences
- Iterate through the sorted list to group consecutive numbers.
- Numbers are consecutive if each number is exactly 1 more than the previous (e.g., 141, 142, 143).
- Start a new sequence when the current number isn’t consecutive with the previous.
- For the example:
  - Sequence 1: 141, 142, 143 (consecutive: 142 = 141 + 1, 143 = 142 + 1).
  - Sequence 2: 174, 175 (consecutive: 175 = 174 + 1; 174 is not consecutive with 143).
  - Sequence 3: 180 (alone, as 180 is not consecutive with 175).

### 3. Format Each Sequence
- For each sequence:
  - If the sequence has 3 or more numbers, format as "start-end" (e.g., 141, 142, 143 → "141-143").
  - If the sequence has 1 or 2 numbers, list them separated by commas (e.g., 174, 175 → "174,175").
- For the example:
  - Sequence 1: 141, 142, 143 (length 3) → "141-143".
  - Sequence 2: 174, 175 (length 2) → "174,175".
  - Sequence 3: 180 (length 1) → "180".

### 4. Combine the Sequences
- Join all formatted sequences with commas.
- For the example: "141-143,174,175,180".

## Final Output
The formatted page numbers for the input are: **"141-143,174,175,180"**.

## Why This Works
- Sorting ensures the numbers are in ascending order as required.
- Grouping into sequences allows us to apply the formatting rules correctly.
- The rule of using "-" for sequences of 3 or more consecutive pages and "," for shorter sequences or individual pages ensures the output is concise.