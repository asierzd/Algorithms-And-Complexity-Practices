# Algorithms-And-Complexity-Practices
These are my solutions to the practices of Algorithms and complexity subject written in Java. Each practice has a set of tests of correctness of the developed solutions and the teachers also took into account the execution time for each practice for the final grade (the optimization of our solutions).

## Index
- **P0 Sorting Algorithms:** Sorting algorithms and their complexity, comparison in execution time.
- **P1 Divide and Conquer:** Divide and conquer based problem solution.

    The goal of this practice is to perform the sum of all of the positive elements of a circularly sorted vector. For the first part it has to be developed with a worst case algorithmic complexity of O(N), and for the second part, it has to be developed with a worst case complexity of O(LogN).

    A circularly sorted vector is defined as follows: $\quad v[N-1] \leq v[0] \quad \land \quad \exists k \quad with \quad 0 < k < N \quad \\ \mid \quad \forall i \neq k \quad v[i] \leq v[i+1]$

- **P2 Backtracking:** Backtracking and Branch and Bound for problem optimization.

    In order to succesfully solve this problem, it has to be applied bounding in order to discard candidates and optimize the search. The goal is to find the minimum number of mutations that the string1 requires to transform into string2. The available operations are maintaining, changing, removing or inserting characters ('A', 'G', 'C', 'T').

    In the following example, the minimum number of mutations in order to transform the string s1 into string s2 is 3:

    ![BacktrackingExample](https://github.com/asierzd/Algorithms-And-Complexity-Practices/blob/master/imgs/BacktrackingExample.png) 

- **P3 Greedy:** Greedy algorithm for candidate selection and feasible solutions.

    Implement a greedy algorithm that maximizes the filling of an inventory with a set of objects of different sizes (width x height) and different values. It is not needed the optimal solution but an approximation.

    For example, if we first have in our inventory an object with id 0 with dimensions 3x2, an object with id 5 (1x2) and an object with id 7 (2x2) (first image), and we add an object with id 1 (1x3) (second image), and finally add an object with id 2 (3x2), we obtain a final inventory as shown in the last image:

    ![GreedyExample](https://github.com/asierzd/Algorithms-And-Complexity-Practices/blob/master/imgs/GreedyExample.png)

- **P4 Dynamic Programming:** Dynamic programming problem, text processor.

    `// TODO`

## License
[GPL-3.0](https://www.gnu.org/licenses/gpl-3.0.html)
