public class Main {
    public static void main(String[] args) {
        int[][] array = {{1, 3, 4, 5}, {7, 2, 3, 4}, {1, 3, 2, 1}};

        int maxRow = 0;
        int maxColumn = 0;
        int maxValue = array[0][0];

        // Iterate over the array to find the maximum value and its position
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        System.out.println("The row with the maximum value is: " + maxRow);
    }
}
