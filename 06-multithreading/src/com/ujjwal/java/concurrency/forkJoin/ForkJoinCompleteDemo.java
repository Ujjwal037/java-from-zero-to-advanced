package com.ujjwal.java.concurrency.forkJoin;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCompleteDemo {

    // RecursiveTask for sum calculation
    static class SumTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 10_000;

        private final int start;
        private final int end;

        SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }

            int mid = (start + end) / 2;

            SumTask leftTask = new SumTask(start, mid);
            SumTask rightTask = new SumTask(mid + 1, end);

            leftTask.fork(); // async split
            long rightResult = rightTask.compute(); // compute directly
            long leftResult = leftTask.join(); // wait & combine

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(1, 1_000_000);

        long result = pool.invoke(task);

        System.out.println("Sum Result: " + result);

        pool.shutdown();
    }
}

