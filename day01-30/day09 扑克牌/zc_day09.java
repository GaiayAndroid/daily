public class TestDemo {
	 //3��2�գ����˿���������� 5 ����,�ж��ǲ���˳��,���� 5 �����ǲ��������ġ� 2-10 Ϊ���ֱ���,A Ϊ 1,J Ϊ 11,Q Ϊ 12,K Ϊ 13,����С�����Կ�������� ���֡�
    @Test
    public void test2() {
        int[] arr = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int [] number = null;
        number = randInts(arr);
        while (!isContinuous(number)) {
            number = null;
            number = randInts(arr);
            System.out.println("����˳�� == " + isContinuous(number));
        }
        System.out.println("�ǲ���˳�� == " + isContinuous(number));
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
        //����������0�ĸ���
        for (int i = 0; i < number.length && number[i] == 0; i++) {
            numberZero++;
        }
        //ͳ�������еļ����Ŀ
        int small = numberZero;
        int big = small + 1;
        while (big < number.length) {
            //��������ȣ��ж��ӣ���������˳��
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