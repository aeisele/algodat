// https://www.interviewcake.com/question/java/merge-sorted-arrays
//
// input arrays are sorted
public class MergeArrays {

    public static int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {
        boolean oneEmpty = arrayOne == null || arrayOne.length == 0;
        boolean twoEmpty = arrayTwo == null || arrayTwo.length == 0;
        if (oneEmpty && twoEmpty) {
            return new int[]{};
        } else if (oneEmpty) {
            return arrayTwo;
        } else if (twoEmpty) {
            return arrayOne;
        }

        int[] result = new int[arrayOne.length + arrayTwo.length];
        int idxOne = 0, idxTwo = 0, i = 0;
        while (i < result.length
                && idxOne < arrayOne.length
                && idxTwo < arrayTwo.length) {
            if (arrayOne[idxOne] <= arrayTwo[idxTwo]) {
                result[i] = arrayOne[idxOne++];
            } else {
                result[i] = arrayTwo[idxTwo++];
            }
            i++;
        }

        if (i < result.length) {
            if (idxOne < arrayOne.length) {
                System.arraycopy(arrayOne, idxOne, result, i, result.length - i);
            }
            if (idxTwo < arrayTwo.length) {
                System.arraycopy(arrayTwo, idxTwo, result, i, result.length - i);
            }
        }

        return result;
    }

}
