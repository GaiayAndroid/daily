package homework;

import java.util.Arrays;

public class day07 {
	// ASasdHnaSD
	public static String sortStr(String str) {
		char[] chars = str.toCharArray();
		boolean flag = false;
		for (int i = 0; i < chars.length - 1; i++) {
			for (int j = 0; j < chars.length - 1 - i; j++) {
				if(Character.isUpperCase(chars[j])&& !Character.isUpperCase(chars[j+1])){
					swap(chars, j ,j+1);
					flag = true;
				}
			}
			if(flag){
				flag = false;
			}else{
				break;
			}
		}
		
		return Arrays.toString(chars);
	}

	public static void swap(char[] chars, int j, int i) {
		char temp = chars[j];
		chars[j] = chars[i];
		chars[i] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(sortStr("AkjHGiasdafASsdfVCXV"));
	}
}
