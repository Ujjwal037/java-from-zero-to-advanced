#  Stream Must Solve Questions
Mastering Java 8 Streams is essential for modern Java development and cracking high-paying technical interviews. 
Below is a structured, comprehensive curriculum of 50 hands-on coding questions divided into five distinct categories of 10 questions each, complete with inputs and outputs

# Category 1: Easy 
1. Filter Even Numbers
   Problem: Given a list of integers, filter out only the even numbers.

Input: List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

Output: [2, 4, 6, 8, 10]

2. Convert Strings to Uppercase
   Problem: Convert a list of lowercase strings to uppercase using streams.

Input: List<String> names = Arrays.asList("apple", "banana", "cherry");

Output: [APPLE, BANANA, CHERRY]

3. Length of the Longest String
   Problem: Find the length of the longest string in a list of strings.

Input: List<String> words = Arrays.asList("java", "stream", "programming", "code");

Output: 11 (from "programming")

4. Count Strings Starting with a Specific Letter
   Problem: Count how many strings start with the letter 'A' (case-insensitive).

Input: List<String> words = Arrays.asList("Apple", "banana", "Apricot", "cherry", "avocado");

Output: 3

5. Sort Integers in Descending Order
   Problem: Sort a list of integers in descending order.

Input: List<Integer> numbers = Arrays.asList(4, 2, 9, 1, 6);

Output: [9, 6, 4, 2, 1]

6. Find Maximum Element
   Problem: Find the maximum element from a list of integers.

Input: List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23);

Output: 89

7. Check if All Elements are Positive
   Problem: Verify if all numbers in the list are positive (> 0).

Input: List<Integer> numbers = Arrays.asList(5, 10, 15, 20);

Output: true

8. Remove Duplicate Elements
   Problem: Remove duplicate elements from a list using stream operations.

Input: List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

Output: [1, 2, 3, 4, 5]

9. Sum of All Elements
   Problem: Calculate the total sum of all elements in a list of integers.

Input: List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

Output: 100

10. Print Elements Multiplied by 2
    Problem: Iterate through a list and print each element multiplied by 2.

Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

Output: 2 4 6 8

# Category 2: Medium 
11. Group Words by Length
    Problem: Group a list of words by their string length.

Input: List<String> words = Arrays.asList("cat", "elephant", "dog", "tiger", "bat");

Output: {3=[cat, dog, bat], 5=[tiger], 8=[elephant]}

12. Partition Even and Odd Numbers
    Problem: Partition a list of integers into two groups: even and odd numbers.

Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

Output: {false=[1, 3, 5], true=[2, 4, 6]}

13. Find Second Highest Number
    Problem: Find the second highest element in a list of integers.

Input: List<Integer> numbers = Arrays.asList(45, 89, 12, 67, 89, 34);

Output: 67

14. Merge Two Sorted Lists
    Problem: Merge two sorted lists into a single sorted list using streams.

Input: List<Integer> list1 = Arrays.asList(1, 3, 5);, List<Integer> list2 = Arrays.asList(2, 4, 6);

Output: [1, 2, 3, 4, 5, 6]

15. Frequency of Each Character in a String
    Problem: Count the frequency of each character in a given string.

Input: String str = "javaprogramming";

Output: {a=3, g=2, i=2, j=1, m=2, o=1, p=2, r=2, v=1}

16. Find First Non-Repeated Character
    Problem: Find the first non-repeated character in a string.

Input: String str = "swiss";

Output: w

17. Filter Employees by Salary
    Problem: Given a list of Employee objects, find all employees earning more than 50,000.

Input: [Emp(Alice, 45000), Emp(Bob, 60000), Emp(Charlie, 75000)]

Output: [Emp(Bob, 60000), Emp(Charlie, 75000)]

18. Sum of First 10 Natural Numbers
    Problem: Use IntStream.range or rangeClosed to find the sum of the first 10 natural numbers (1 to 10).

Input: Range 1 to 10

Output: 55

19. Total Transaction Amount
    Problem: Given a list of transactions with amounts, compute the total sum.

Input: List<Transaction> transactions = [Tx(100), Tx(250), Tx(50)];

Output: 400.0

20. Skip and Limit Operations
    Problem: Skip the first 3 elements and limit the stream to the next 4 elements.

Input: List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);

Output: [40, 50, 60, 70]

# Category 3: Hard
21. Top 3 Maximum Elements
    Problem: Find the top 3 maximum elements from a list of integers.

Input: List<Integer> numbers = Arrays.asList(10, 45, 2, 89, 33, 99, 56);

Output: [99, 89, 56]

22. Concatenate Strings with Prefix, Suffix, and Delimiter
    Problem: Join a list of strings using Collectors.joining with a prefix [, suffix ], and delimiter , .

Input: List<String> list = Arrays.asList("Java", "Python", "C++");

Output: [Java, Python, C++]

23. Average Salary by Department
    Problem: Group employees by department and calculate the average salary for each department.

Input: List<Employee> with Dept (IT, HR) and Salaries.

Output: {IT=65000.0, HR=52000.0}

24. Longest String via Reduce
    Problem: Find the longest string in a list using the reduce operation.

Input: List<String> words = Arrays.asList("spring", "hibernate", "microservices");

Output: microservices

25. Flatten List of Lists and Square Numbers
    Problem: Flatten a List<List<Integer>> into a single list of squared numbers.

Input: List<List<Integer>> list = [[1, 2], [3, 4], [5]];

Output: [1, 4, 9, 16, 25]

26. Duplicate Elements and Counts
    Problem: Identify duplicate elements in a list along with their occurrence counts.

Input: List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

Output: {apple=3, banana=2}

27. Partition Students by Passing Marks
    Problem: Partition students into passing (marks > 40) and failing, returning a map of names.

Input: List<Student> with (Name, Marks: 35, 78, 90, 20)

Output: {false=[John (35), David (20)], true=[Alice (78), Bob (90)]}

28. Intersection of Two Lists
    Problem: Find the common elements (intersection) between two lists using streams.

Input: list1 = [1, 2, 3, 4, 5], list2 = [3, 4, 5, 6, 7]

Output: [3, 4, 5]

29. Custom Reduction for Product
    Problem: Compute the product of all elements in a list using a custom binary operator reduction.

Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

Output: 24

30. Split Sentences into Distinct Sorted Words
    Problem: Given a list of sentences, split them into words, remove duplicates, and sort alphabetically.

Input: List<String> sentences = ["Hello world", "Java stream world"];

Output: [Hello, Java, stream, world] (or lowercased depending on normalization)

# Category 4: Most Frequently Asked in Interviews (Common Interview Patterns)
31. Numbers Starting with 1
    Problem: Given a list of integers, find all numbers that start with the digit 1 (by converting them to strings).

Input: List<Integer> numbers = Arrays.asList(10, 15, 23, 31, 105, 42);

Output: [10, 15, 105]

32. First Non-Repeated Character in Stream Style
    Problem: Find the first non-repeated character in a string using Streams and LinkedHashMap.

Input: String input = "JavaStreams";

Output: J (or v depending on case sensitivity handling)

33. First Repeated Character
    Problem: Find the first repeated character in a string using Java 8 streams.

Input: String input = "programming";

Output: r

34. Sort Employees by Name (Ascending) then Salary (Descending)
    Problem: Sort an employee list primarily by name ascending, and secondarily by salary descending.

Input: Unsorted List<Employee>

Output: List ordered alphabetically by name, and if names match, highest salary first.

35. Maximum and Minimum Salary from Employee List
    Problem: Find both the maximum and minimum salary using Collectors.summarizingDouble or min/max.

Input: List<Employee> with various salaries.

Output: Max: 95000.0, Min: 30000.0

36. Check for Duplicate Elements (Return Boolean)
    Problem: Return true if a list contains any duplicate values, false otherwise.

Input: List<Integer> list = Arrays.asList(1, 2, 3, 4, 1);

Output: true

37. Cube Numbers and Filter
    Problem: Find the cube of each number in a list and filter out those greater than 50.

Input: List<Integer> numbers = Arrays.asList(2, 3, 4, 5); (Cubes: 8, 27, 64, 125)

Output: [64, 125]

38. Transaction with Maximum Value
    Problem: Find the transaction object that has the maximum value.

Input: List<Transaction> with amounts [100, 500, 250]

Output: Transaction{amount=500}

39. Generate First 10 Odd Numbers
    Problem: Generate the first 10 odd numbers using Stream.iterate.

Input: Seed 1, increment by 2, limit 10

Output: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]

40. List to Map with Duplicate Key Handling
    Problem: Convert a list of items into a Map, handling duplicate keys by merging their values (e.g., summing quantities).

Input: List of items with duplicate names and quantities.

Output: Map<String, Integer> with unique keys and combined quantities.

# Category 5: Advanced level Interview Questions
41. Highest-Paid Employee in Each Department
    Problem: Find the employee with the maximum salary in each department.

Input: List<Employee> across multiple departments.

Output: Map<String, Employee> mapping each Department name to its highest-paid Employee object.

42. Implement a Custom Collector
    Problem: Build a custom collector using Collector.of() to accumulate elements into an unmodifiable custom set.

Input: List<String> list = Arrays.asList("a", "b", "c", "a");

Output: Custom unmodifiable set containing [a, b, c]

43. Department Employee Count Sorted Descending
    Problem: Group employees by department, count the headcount per department, and return departments sorted by headcount in descending order.

Input: Company employee records.

Output: LinkedHashMap or sorted list: [IT: 15, HR: 8, Finance: 5]

44. Second Highest Salary in Each Department
    Problem: For each department, find the employee who receives the second highest salary.

Input: Comprehensive List<Employee> across departments.

Output: Map<String, Optional<Employee>> containing the second highest earner per department.

45. Top 3 Most Frequently Purchased Items
    Problem: Given a list of orders containing line items, use flatMap and grouping to find the top 3 most frequently purchased item names across all orders.

Input: List<Order> with nested items.

Output: [Laptop, Mouse, Keyboard]

46. Parallel Stream Safe Reduction & Performance Tuning
    Problem: Process a massive list of numbers using a parallel stream to compute a sum safely without incurring race conditions or state-pollution side effects.

Input: List<Integer> with 1,000,000 elements.

Output: Accurate aggregated sum computed concurrently.

47. Comprehensive Statistics via summarizingInt
    Problem: Use Collectors.summarizingInt to calculate count, sum, min, max, and average age of a list of persons in a single pass.

Input: List<Person> with ages [25, 30, 35, 40]

Output: IntSummaryStatistics{count=4, sum=130, min=25, average=32.5, max=40}

48. Cumulative Sum (Running Total)
    Problem: Generate a running total (cumulative sum) list from an input list of integers using streams or stateful reduction.

Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

Output: [1, 3, 6, 10, 15]

49. Partition and Payroll by Company Average
    Problem: Partition employees into two groups: those earning above the company average salary and those earning below, and calculate the total payroll (sum of salaries) for both partitions.

Input: List<Employee> with salaries.

Output: {false=TotalPayrollBelowAvg, true=TotalPayrollAboveAvg}

50. Anagram Grouper
    Problem: Given a list of words, group them into lists of words that are anagrams of each other using a normalized character array or sorted string key.

Input: List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

Output: [[eat, tea, ate], [tan, nat], [bat]]