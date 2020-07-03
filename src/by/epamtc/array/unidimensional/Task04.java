package by.epamtc.array.unidimensional;

public class Task04 {

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 3, 4, 5, 1, 6};
        System.out.println(minPopularNumber(data));
    }

    public static int minPopularNumber(int[] arr) {
        int popElement = 0;
        int popCount = 1;

        for (int i = 0; i < arr.length; i++) {
            int curElement = arr[i];
            int curCount = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (curElement == arr[j]) {
                    curCount++;
                }
            }

            if (curCount > popCount) {
                popCount = curCount;
                popElement = curElement;
            }
            if (curCount == popCount) {
                popElement = Math.min(popElement, curElement);
            }
        }

        return popElement;
    }
}
