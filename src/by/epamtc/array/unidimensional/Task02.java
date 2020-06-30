package by.epamtc.array.unidimensional;

import java.util.Arrays;

public class Task02 {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 3, 4, 5, 1, 6};
        System.out.println(Arrays.toString(removeMinElement(data)));
    }

    public static int[] removeMinElement(int[] sequence) {
        int minElement = Integer.MAX_VALUE;

        for (Integer element : sequence) {
            if (element < minElement) {
                minElement = element;
            }
        }

        return removeElement(sequence, minElement);
    }

    private static int[] removeElement(int[] sequence, int element) {
        int elementsCount = 0;

        for (Integer value : sequence) {
            if (value == element) {
                elementsCount++;
            }
        }
        int[] newSequence = new int[sequence.length - elementsCount];

        int newIndex = 0;
        for (int value : sequence) {
            if (value != element) {
                newSequence[newIndex] = value;
                newIndex++;
            }
        }

        return newSequence;
    }
}
