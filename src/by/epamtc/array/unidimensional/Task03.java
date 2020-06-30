package by.epamtc.array.unidimensional;

import java.util.Arrays;

public class Task03 {

    public static void main(String[] args) {
        int[] lock1 = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] lock2 = new int[]{0, 4, 5, 0, 0, 0, 0, 0, 0, 0};
        int[] lock3 = new int[]{0, 0, 0, 0, 0, 0, 0, 6, 0, 4};

        unlock(lock1);
        unlock(lock2);
        unlock(lock3);
    }

    public static void unlock(int[] lockSequence) {
        for (int i = 0; i < lockSequence.length - 2; i++) {
            int first = lockSequence[i];
            int second = lockSequence[i + 1];
            int third = lockSequence[i + 2];

            boolean unlocked = canInsert(first, second, third);
            if (unlocked) {
                break;
            }
        }
    }

    private static boolean canInsert(int first, int second, int third) {
        int[] sequence = new int[]{first, second, third};
        int cubesToInsert = 0;

        for (Integer element : sequence) {
            if (element == 0) {
                cubesToInsert++;
            }
        }

        int sum = first + second + third;
        if (sum >= 10) {
            return false;
        }

        if ((cubesToInsert == 1) && (sum >= 4)) {
            insertOneCube(sum, sequence);
            return true;
        }

        if ((cubesToInsert == 2) & (sum > 0)) {
            insertTwoCubes(sum, sequence);
            return true;
        }

        return false;
    }

    private static void insertOneCube(int sum, int[] sequence) {
        int firstCube = 10 - sum;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 0) {
                sequence[i] = firstCube;
            }
        }

        System.out.println(Arrays.toString(sequence));
    }

    private static void insertTwoCubes(int sum, int[] sequence) {
        int sumOfCubes = 10 - sum;
        int firstCube = 0;
        int secondCube = 0;

        if (sumOfCubes > 7) {
            firstCube = 10 - sum - 6;
        } else {
            firstCube = 10 - sum - 1;
        }
        secondCube = 10 - (firstCube + sum);

        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < sequence.length; i++) {

            if (sequence[i] == 0 && firstIndex == -1) {
                firstIndex = i;
            } else if (sequence[i] == 0 && firstIndex != -1) {
                secondIndex = i;
            }

        }

        sequence[firstIndex] = firstCube;
        sequence[secondIndex] = secondCube;

        System.out.println(Arrays.toString(sequence));
    }
}
