package cop2805;

import java.util.Scanner;

public class CCulpHomework7 {
    public static void main(String[] args) {
        RecursiveFib recur = new RecursiveFib();
        DynamicFib dynam = new DynamicFib();
        Scanner sc = new Scanner(System.in);
        int target = 0;

        System.out.println("Enter target fibonacci index: ");
        target = sc.nextInt();
        recur.setN(target);
        dynam.setN(target);

        dynam.start();
        recur.start();
    }
}

class RecursiveFib extends Thread {
    int n;
    Integer result;
    long startTime, endTime;

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        result = fibonacciRecursive(n);
        endTime = System.currentTimeMillis();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String res;
        if (result.equals(null)) {
            res = String.format("RecursiveFib did not run for some reason.");
        }
        return String.format("RecursiveFib returned response %d in %dms", result, (endTime - startTime));
    }

    public int fibonacciRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2));
    }

}

class DynamicFib extends Thread {
    int n;
    Integer result;
    long startTime, endTime;

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        result = fibonacciDynamic(n);
        endTime = System.currentTimeMillis();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String res;
        if (result.equals(null)) {
            res = String.format("DynamicFib did not run for some reason.");
        }
        return String.format("DynamicFib returned response %d in %dms", result, (endTime - startTime));
    }

    private int fibonacciDynamic(int n) {
        int a = 0, b = 1, c;

        if (n == 0) {
            return a;
        }
        for (int i = 2; i <= n; ++i) {
            c = a + b;
            a = b;
            b = c;

        }
        return b;
    }
}
