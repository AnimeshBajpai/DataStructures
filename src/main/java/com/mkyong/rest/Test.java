package com.mkyong.rest;

class R {
    int sum = 0;
}

class Test {
    public static void main(String[] a) {

//        0,0,0,5
//        0,1,1,5
//        0,1,0,0
//        1,0,0,0
        int[][] inp = {{0, 0, 0, 5}, {0, 1, 1, 5}, {0, 1, 0, 0}, {1, 0, 0, 0}};
        int result = new Test().solve(inp);
        System.out.print(result);
    }

    int solve(int[][] a) {
        int len = a.length;
        R r = new R();
        boolean[][] visited = new boolean[4][4];
        visited[3][0] = true;
        solveUtil(a, len - 1, 0, 0, r, visited);
        return r.sum;
    }

    void solveUtil(int[][] a, int cx, int cy, int cSum, R r, boolean[][] visited) {
        if (cx == 0 && cy == a.length - 1) {
            r.sum = r.sum < cSum + a[cx][cy] ? cSum + a[cx][cy] : r.sum;
            return;
        }
        int[] x = new int[]{-1, 0, 0, 1};
        int[] y = new int[]{0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            if (isSafe(a, cx + x[i], cy + y[i]) && !visited[cx + x[i]][cy + y[i]]) {
                visited[cx + x[i]][cy + y[i]] = true;
                solveUtil(a, cx + x[i], cy + y[i], cSum + a[cx][cy], r, visited);
                visited[cx + x[i]][cy + y[i]] = false;
            }
        }
    }

    boolean isSafe(int[][] a, int i, int j) {
        return i >= 0 && j >= 0 && i < a.length && j < a[0].length;
    }
}
//    public static void main(String[] args) {
//        int[] A = new int[]{-1, 4, -1, 3, 2};
//        int k = 0;
//        int listLength = 1;
//        while (A[k] != -1) {
//            System.out.println(A[k]);
//            k = A[k];
//            listLength++;
//        }
//        System.out.println(listLength);
//    }
//
//    static int getCountOfSquareRoots(double num) {
//        double sqrt = Math.sqrt(num);
//        if (sqrt % 1 != 0) {
//            return 0;
//        } else {
//            return 1 + getCountOfSquareRoots(sqrt);
//        }
//    }
//
//    static int findTheMaximumNumberOfRepeatedSqaureRoots(int A, int B) {
//        double pointer = A;
//        int max_count = 0;
//
//        while (pointer <= B) {
//            double sqrt = Math.sqrt(pointer);
//            if (sqrt % 1 == 0) {
//                int num = getCountOfSquareRoots(pointer);
//                if (num > max_count) {
//                    max_count = num;
//                }
//            }
//            int val = (int) (sqrt / 1) + 1;
//            pointer = val * val;
//        }
//
//        return max_count;
//    }

//    public static int solution(int A, int B) {
//        // write your code in Java SE 8
//        int temp = 0;
//        int result = 0;
//        if (A > B) {
//            return 0;
//        }
//        int sqA = (int) Math.ceil(Math.sqrt(A));
//        int sqB = (int) Math.floor(Math.sqrt(B));
//        if (sqA > sqB) {
//            return 0;
//        }
//        //recursive call for again calling the square root of a rooted digit
//        return 1 + solution(sqA, sqB);
//    }
//
    //    static boolean palendrom(String str) {
//        String s = str;
//        String temp = "";
//        for (int i = s.length() - 1; i >= 0; i--) {
//            temp = temp + s.charAt(i);
//
//        }
//
//        if (temp.equalsIgnoreCase(str)) {
////System.out.println(temp+"......"+str);
//            return true;
//        } else {
////System.out.println(temp+"......"+str);
//            return false;
//        }
//    }
//
//    public static void main(String args[]) throws Exception {
//        //String line = "122243323341";
//        String line = "random12321random";
//
//        int maxlenght = 0;
//        String substr;
//        if (palendrom(line)) {
//            if (isPrime(maxlenght))
//                System.out.println("YES");
//        } else {
//
//            for (int i = 0; i <= line.length(); i++) {
//
//                for (int k = i; k <= line.length(); k++) {
//                    substr = line.substring(i, k);
//
//                    if (palendrom(substr)) {
//                        if (substr.length() > maxlenght)
//                            maxlenght = substr.length();
//                    }
//
//                }
//
//
//            }
////System.out.println("max digit of palendrom:"+maxlenght);
//            if (isPrime(maxlenght)) {
//                System.out.println(maxlenght);
//                System.out.println("YES");
//            }
//
//        }
//    }
//
//    public static boolean isPrime(int prime) {
//        // Do not use the number to check for prime as loop variable, also it's
//        // sufficient to iterate till the square root of the number to check
//        for (int number = 2; number < Math.sqrt(prime); number++) {
//            if (prime % number == 0) {
//                return false;
//            }
//        }
//
//        // You didn't always return a value, it won't let you compile otherwise
//        return true;
//    static void maxSubArraySum(int a[], int size) {
//        int max_so_far = Integer.MIN_VALUE,
//                max_ending_here = 0, start = 0,
//                end = 0, s = 0;
//
//        for (int i = 0; i < size; i++) {
//            max_ending_here += a[i];
//
//            if (max_so_far < max_ending_here) {
//                max_so_far = max_ending_here;
//                start = s;
//                end = i;
//            }
//
//            if (max_ending_here < 0) {
//                max_ending_here = 0;
//                s = i + 1;
//            }
//        }
//        System.out.println("Maximum contiguous sum is "
//                + max_so_far);
//        System.out.println("Starting index " + start);
//        System.out.println("Ending index " + end);
//    }
//
    // Driver code
//    public static void main(String[] args) {
//        int a[] = {-2, -3,1,5,-1,10};
//        int n = a.length;
//        maxSubArraySum(a, n);
//        List s = new ArrayList();
//        s.add(12);
//        s.add(12);
//        s.add(12);
//        s.add(null);
//        s.removeAll(Collections.singleton(null));
//        System.out.print(s);
//    }

