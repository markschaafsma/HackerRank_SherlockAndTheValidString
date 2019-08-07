# HackerRank_SherlockAndTheValidString

### Problem 

Sherlock considers a string to be valid if all characters of the string appear the same 
number of times. It is also valid if he can remove just 1 character at 1 index in the 
string, and the remaining characters will occur the same number of times. Given a string 
s, determine if it is valid. If so, return YES, otherwise return NO.
  
For example, if s = abc, it is a valid string because frequencies are {a:1,b:1,c:1}. 
So is s = abcc because we can remove one c and have 1 of each character in the remaining 
string. If s= abccc however, the string is not valid as we can only remove 1 occurrence 
of c. That would leave character frequencies of (a:1, b:1,c:2).
   
### Function Description

Complete the isValid function. It should return either the string YES 
or the string NO.

isValid has the following parameter(s):
   - s: a string
   
### Input Format
 
   - A single string s.
   
### Constraints
 
   - 1 <= |s| <= 10 pow 5
   - Each character s[i] belongs to the set ascii[a-z] 
 
### Output Format
 
   - Print YES if string  is valid, otherwise, print NO.

### Testcases

   - Testcase 0
	    - Input
	      -  aabbcd
	    - Expected Output
	      -  NO
	    - Explanation
	      -  Given s="aabbcd", we would need to remove two characters, both c and d to give "aabb", 
	      -  or remove a and b to give "abcd" to make it valid. We are limited to removing only one 
	      -  character, so s is invalid.
