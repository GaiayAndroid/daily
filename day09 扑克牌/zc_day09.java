public class TestDemo {
	 //3月2日：从扑克牌中随机抽 5 张牌,判断是不是顺子,即这 5 张牌是不是连续的。 2-10 为数字本身,A 为 1,J 为 11,Q 为 12,K 为 13,而大小王可以看成任意的 数字。
    @Test
    public void test2() {
        int[] arr = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int [] number = null;
        number = randInts(arr);
        while (!isContinuous(number)) {
            number = null;
            number = randInts(arr);
            System.out.println("不是顺着 == " + isContinuous(number));
        }
        System.out.println("是不是顺着 == " + isContinuous(number));
    }

    private int[] randInts(int[] arr) {
        int[] number = new int[5];
        for (int i = 0; i < number.length; i++) {
            int idx = (int) (Math.random() * arr.length);
            System.out.println(arr[idx]);
            number[i] = arr[idx];
        }
        return number;
    }

    private boolean isContinuous(int[] number) {

        if (number == null) {
            return false;
        }
        Arrays.sort(number);
        int numberZero = 0;
        int numberGap = 0;
        //计算数组中0的个数
        for (int i = 0; i < number.length && number[i] == 0; i++) {
            numberZero++;
        }
        //统计数组中的间隔数目
        int small = numberZero;
        int big = small + 1;
        while (big < number.length) {
            //两个数相等，有对子，不可能是顺子
            if (number[small] == number[big]) {
                return false;
            }
            numberGap += number[big] - number[small] - 1;
            small = big;
            big++;
        }
        return (numberGap > numberZero) ? false : true;

}
	}