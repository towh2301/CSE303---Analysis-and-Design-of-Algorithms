# Lab2.EIUQBHV - Possible Passwords

## Problem Statement

Duy is a gamer who forgot his League of Legends password and wrote it on a piece of paper. Unfortunately, the pet dog Warwicky chewed up the paper, leaving Duy unsure of the character order. Duy needs to log in to practice for the upcoming world final. Your task is to help Duy list all possible passwords by generating all permutations of the given string, sorted lexicographically.

### Input
- A string with `N` capital letters (`1 <= N <= 9`)

### Output
- **First line:** `M`, the number of possible passwords (i.e., the number of distinct permutations).
- **Next `M` lines:** All possible passwords, sorted lexicographically.

### Note
- Pseudocode for this problem can be found in *Text Book page 172 (Introduction to the Design & Analysis of Algorithms)*.
- Link: [Pseudocode](https://drive.google.com/file/d/16IW_BgOvOvp1rFrivjWL4cNH3AyEV2E/view?usp=drive_link)

### Example
**Input:**
```
ABC
```

**Output:**
```
6
ABC
ACB
BAC
BCA
CAB
CBA
```

## Explanation

### Problem Analysis
- The task is to generate all possible permutations of a given string of capital letters and output them in lexicographical order.
- The string length `N` is between 1 and 9, so the number of permutations is manageable (e.g., for `N=9`, the maximum number of permutations is `9! = 362,880`).
- If the string has duplicate characters, we need to ensure that we only count distinct permutations.

### Approach
1. **Read the Input:**
   - Input is a single string of capital letters (e.g., `ABC`).

2. **Generate Permutations:**
   - We need to generate all permutations of the string.
   - Since the problem requires distinct permutations, if there are duplicate characters, we must avoid counting duplicate permutations.

3. **Sort Lexicographically:**
   - Sort all permutations in lexicographical order (alphabetical order for strings).

4. **Output:**
   - First, output the total number of distinct permutations.
   - Then, output each permutation on a new line.

### Example Walkthrough
**Input:** `ABC`
- **Step 1: Generate all permutations**
  - Characters: `A`, `B`, `C` (all distinct).
  - Permutations: `ABC`, `ACB`, `BAC`, `BCA`, `CAB`, `CBA`.
  - Total permutations: `3! = 6` (since all characters are distinct).
- **Step 2: Sort lexicographically**
  - Sorted order: `ABC`, `ACB`, `BAC`, `BCA`, `CAB`, `CBA`.
- **Step 3: Output**
  - First line: `6` (number of permutations).
  - Next 6 lines: `ABC`, `ACB`, `BAC`, `BCA`, `CAB`, `CBA`.

**What if there are duplicates?**
- If the input were `AAB`:
  - All permutations: `AAB`, `ABA`, `AAB`, `ABA`, `BAA`, `BAA`.
  - Distinct permutations: `AAB`, `ABA`, `BAA`.
  - Number of distinct permutations: `3!/2! = 3` (since `A` appears twice).
  - Sorted: `AAB`, `ABA`, `BAA`.

### Solution Strategy
- **Using Java:**
  - Use a `Set` to store distinct permutations (to handle duplicates automatically).
  - Generate permutations using recursion or a library function.
  - Sort the permutations and output them.

- **Recursive Approach for Permutations:**
  1. Base case: If the string is empty, return a list with an empty string.
  2. For each character in the string:
     - Take the character as the first character.
     - Recursively generate permutations of the remaining characters.
     - Combine the character with each permutation of the remaining characters.
  3. Use a `Set` to ensure distinct permutations.
  4. Convert to a `List`, sort, and output.

### Pseudocode
```plaintext
function generatePermutations(s):
    if s is empty:
        return [""]
    result = []
    for i from 0 to length(s)-1:
        char = s[i]
        remaining = s without char at index i
        subPerms = generatePermutations(remaining)
        for each perm in subPerms:
            add (char + perm) to result
    return result

main:
    read string s
    perms = generatePermutations(s)
    distinctPerms = convert perms to a Set to remove duplicates
    sortedPerms = sort distinctPerms lexicographically
    print length of sortedPerms
    for each perm in sortedPerms:
        print perm
```

### Time Complexity
- For a string of length `N` with all distinct characters:
  - Total permutations: `N!`.
  - Generating all permutations: `O(N!)`.
  - Sorting: `O(N! * log(N!))`.
- If there are duplicates, the number of distinct permutations will be less (e.g., for `AAB`, it's `3!/2!`).
- Space Complexity: `O(N!)` to store all permutations.

### Notes
- The problem constraints (`N <= 9`) ensure that `N!` is manageable.
- Using a `Set` to handle duplicates is efficient for this problem size.
- Java’s `Collections.sort()` can be used for lexicographical sorting.