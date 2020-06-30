package by.epamtc.array.unidimensional;

public class Task01 {

    public static void main(String[] args) {
        double max = maxSum(new double[]{2.5, 3.2, 5.0, 4.12, 1.3, 2.0});
        System.out.printf("%f\n", max);
    }

    public static double maxSum(double[] evenLengthArray) {
        double max = Double.MIN_VALUE;
        int length = evenLengthArray.length;

        int tail = length - 1;
        for (int head = 0; head < length / 2; head++) {

            double sum = evenLengthArray[head] + evenLengthArray[tail];
            tail--;
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
