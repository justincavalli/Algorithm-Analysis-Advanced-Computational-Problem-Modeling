# Summary:
The proj2.java file has 4 algorithms that each find the maximum sequence of an array: threeLoops, twoLoops, recursiveSum, and oneLoop. The resulting maximum is the same answer for each algorithm run, but the efficiency varies across algorithms.

# Complexity Analysis and Algorithm Descriptions:
## threeLoops
_Description:_ Uses 3 nested for loops where the 1st loop sets the start of the sequence, the second loop sets the right end of the subsequence, and the third loop sums the subsequence and checks that sum against the maximum sum.<br/>
_Time Complexity:_ O(n) = n^3
## twoLoops
_Description:_  Uses 2 nested for loops where the first sets the start of the subsequence, then the second loop sets the right end of the subsequence and also sums up the subsequence to check against the current maximum.<br/>
_Time Complexity:_ O(n) = n^2
## recursiveSequence
_Description:_ Recursively partitions the array into two equal halves, computes the max-left, max-right, max-left-bound, max-right-bound sums and returns the maximum of all 4 sums.<br/>
_Time Complexity:_ O(n) = n*log(n)
## oneLoop
_Description:_ Uses one for loop to read in each number of the array into a running sum, checking that sum to the current maximum. If the sum drops below 0 at any points it begins a new sequence at 0 starting with the next item.<br/>
_Time Complexity:_ O(n) = n


Array Size | threeLoops | twoLoops | recursive | oneLoop
------------ | ------------- | ------------ | ------------- | -------------
n=6 | 3,484 ns | 2,017 ns | 8,094 ns | 1,101 ns
n=20 | 131,252 ns | 3,995 ns | 34,550 ns | 1,120 ns
n=100 | 5,198,955 ns | 73,674 ns | 88,975 ns | 2,500 ns
n=300 | 10,108,037 ns | 664,665 ns | 234,874 ns | 5,685 ns
n=500 | 15,292,395 ns | 3,287,773 ns | 277,821 ns | 6,031 ns

*time in nanoseconds



# Conclusion:
Through our trials we found that our results were as expected. The threeLoops function took the most time for nearly all array sizes, and the oneLoop function always took the least amount of time. The twoLoops algorithm is always faster than the threeLoops algorithm. With very small array sizes (n), the recursive algorithm took longer than twoLoops and even threeLoops with a size of n = 6. Varying based on the computer's performance at runtime, the recursive algorithm was better than the twoLoops algorithm after n is greater than about 100. Similarly the recursive sum was faster than the threeLoops algorithm after n is greater than about 8-10. Our proj2.java class takes the average of 50 trials for each algorithm to find the best estimate, but even with many cases the results still varied at times based on computer system specifications that were out of our control.
