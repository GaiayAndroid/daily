public class Dichotomy {
    int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
//    int[] test1 = {48, 25, 23, 12, 9, 8, 4, 3, 2};

    @Test
    public void main() {
        System.out.println("要查找的key = " + 6 + ", index = " + dichotomy1(test, 6));
//        System.out.println("要查找的key = " + 8 + ", index = " + dichotomy1(test1, 8));
    }

    //二分法查找
    private int dichotomy1(int[] array, int findKey) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (findKey < array[middle]) {
                end = middle - 1;
            } else if (findKey > array[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}