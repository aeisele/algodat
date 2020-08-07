public class LargestSum {

    public static Integer largestSum(int[] numbers) {
        Integer largest = null;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int h = j + 1; h < numbers.length; h++) {
                    int sum = numbers[i] + numbers[j] + numbers[h];
                    if (largest == null || largest < sum) {
                        largest = sum;
                    }
                    System.out.println("[" + i + ", " + j + ", " + h + "] = " + sum);
                }
            }
        }

        System.out.println("largest = " + largest);
        return largest;
    }

}
