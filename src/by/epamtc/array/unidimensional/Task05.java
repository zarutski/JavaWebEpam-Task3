package by.epamtc.array.unidimensional;

public class Task05 {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 3, 4, 5, 1, 6};
        System.out.println(maxEvenMinOddSum(data));
    }

    public static int maxEvenMinOddSum(int[] arr) {
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if ((i % 2 == 1) && (arr[i] > maxOdd)) {
                maxOdd = arr[i];
                continue;
            }
            if ((i % 2 != 1) && (arr[i] < minEven)) {
                minEven = arr[i];
            }
        }

        return minEven + maxOdd;
    }
}
