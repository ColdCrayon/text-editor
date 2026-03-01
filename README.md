# CSC 207: Text Editor

**Authors**:
- John Kafumbe
- Cadel Saszik 

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Part 2: Analyzing Simple String Buffer Runtime

- Relevant Inputs:
  - n (the number of characters in the buffer)
  - i (the position of the cursor (index))

- Critical Operations
 - substring()
 - + (joining: before, ch and, after)

- Mathmatical Model
 - n + (n + 1) = 2n + 1

- Big-O Characterization
 - The insert method is O(n)

- Justification:
 - Since a string cannot be changed once created, an "insertion" is actually a just a remake. Every time insert is called, Java has to allocate totally new memory for a new string object. 