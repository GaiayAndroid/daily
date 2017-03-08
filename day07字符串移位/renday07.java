import org.junit.Test;

import java.util.Arrays;

/**
 * Created by RenTao on 17/2/26.
 */

public class Daily {

    @Test
    public void lowerAndUpper() {
        String str = "OkhaoPingCeilXu";
        // 复杂度O(n)
        char[] arr = str.toCharArray();
        char[] newArr = new char[arr.length];
        int index = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                newArr[index--] = arr[i];
            }
        }
        index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                newArr[index++] = arr[i];
            }
        }
        System.out.println(newArr);
    }
}