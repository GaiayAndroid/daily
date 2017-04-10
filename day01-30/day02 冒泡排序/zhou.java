    @Test
    public void bubbleSort() {
        //ц╟ещеепР
        int[] test = {2, 65, 54, 11, 3, 6, 59, 45, 78};
        for (int i = 0; i < test.length; i++) {
            for (int j = i + 1; j < test.length; j++) {
                if (test[i] > test[j]) {
                    int temp;
                    temp = test[i];
                    test[i] = test[j];
                    test[j] = temp;
                }
            }
        }
        printlnValue(test);
    }
    @Test
    public void bubbleSort1() {
        //ц╟ещеепР
        int[] test = {2, 65, 54, 11, 3, 6, 59, 45, 78};
        for (int i = 0; i < test.length; i++) {
            for (int j = i + 1; j < test.length; j++) {
                if (test[i] < test[j]) {
                    int temp;
                    temp = test[i];
                    test[i] = test[j];
                    test[j] = temp;
                }
            }
        }
        printlnValue(test);
    }

	private void printlnValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[ = " + i + "] = " + array[i]);
        }
    }