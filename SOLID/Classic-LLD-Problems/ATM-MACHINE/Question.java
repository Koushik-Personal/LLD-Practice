import java.util.Scanner;

class Question {

    private static final int MOD = (int) 10e9 + 7;

    private static long solve(int k, int arr[]) {

        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {

            int currentBig = Integer.MIN_VALUE;
            int index = 0;
            for (int j = i; j < n; j++) {
                index++;
                currentBig = Math.max(currentBig, arr[j]);
                sum += (currentBig * index);
            }
        }

        return sum % MOD;
    }

    public static void main(String[] args) {
        int k;
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();

        int[] security = new int[k];

        for (int i = 0; i < k; i++) {
            security[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(solve(k, security));
    }
}