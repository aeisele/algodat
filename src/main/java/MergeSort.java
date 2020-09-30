public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array);
    }

    private void mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return;
        }

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, middle, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray) {
        int currentIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {

            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }

            currentIndex++;
        }

        while (leftIndex < leftArray.length) {
            array[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }

        while (rightIndex < rightArray.length) {
            array[currentIndex] = rightArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
    }

}
