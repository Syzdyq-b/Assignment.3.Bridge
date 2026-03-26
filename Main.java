public class Main {

    // Task 2
    public static void printDescending(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDescending(n - 1);
    }

    // Task 3
    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }

    // Task 4
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Task 5
    public static int power(int a, int b) {
        if (b == 0) return 1;
        return a * power(a, b - 1);
    }

    // Task 6
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    // Task 7
    public static int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    // Task 8
    public static void reverseNumber(int n) {
        if (n == 0) return;
        System.out.print(n % 10);
        reverseNumber(n / 10);
    }

    // Task 9
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Task 10
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    // Task 11
    public static int arraySum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + arraySum(arr, n - 1);
    }

    // Task 12
    public static int findMax(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    // Task 13
    public static int countOccurrences(int[] arr, int n, int target) {
        if (n == 0) return 0;
        if (arr[n - 1] == target)
            return 1 + countOccurrences(arr, n - 1, target);
        else
            return countOccurrences(arr, n - 1, target);
    }

    // Task 14
    public static boolean linearSearch(int[] arr, int n, int target) {
        if (n == 0) return false;
        if (arr[n - 1] == target) return true;
        return linearSearch(arr, n - 1, target);
    }

    // Task 15
    public static boolean isSorted(int[] arr, int n) {
        if (n == 1) return true;
        if (arr[n - 1] < arr[n - 2]) return false;
        return isSorted(arr, n - 1);
    }

    // Task 16 (Bonus)
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        if (target < arr[mid])
            return binarySearch(arr, left, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {

        System.out.println("Sum 1..5 = " + sum(5));
        System.out.println("Factorial 5 = " + factorial(5));
        System.out.println("2^4 = " + power(2, 4));
        System.out.println("Sum of digits 572 = " + sumDigits(572));
        System.out.println("Fibonacci(6) = " + fibonacci(6));

        int[] arr = {3, 5, 2, 7};
        System.out.println("Array sum = " + arraySum(arr, arr.length));
    }
}