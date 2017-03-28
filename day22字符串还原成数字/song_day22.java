package strToNum;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author PVer
 *
 */
public class Main {
	/**
	 * zero one two three four five six seven eight nine
	 * 
	 * e 101 f 102 g 103 h 104 i 105 n 110 o 111 r 114 s 115 t 116 u 117 v 118 w
	 * 119 x 120 z 122
	 * 
	 * 第一次： zero(z) two(w) four(u) six(x) eight(g) 剩下： one three five seven nine
	 * 第二次： one(o) three(r) five(f) seven(s) 剩下： nine
	 */

	public static String numbers = "3,1,2";

	public static Map<Character, char[]> charMap = new HashMap<>();

	public static StringBuilder result = new StringBuilder();

	public static String numToString(char num) {
		if (num == '0') {
			return "zero";
		} else if (num == '1') {
			return "one";
		} else if (num == '2') {
			return "two";
		} else if (num == '3') {
			return "three";
		} else if (num == '4') {
			return "four";
		} else if (num == '5') {
			return "five";
		} else if (num == '6') {
			return "six";
		} else if (num == '7') {
			return "seven";
		} else if (num == '8') {
			return "eight";
		} else if (num == '9') {
			return "nine";
		} else {
			return "";
		}
	}

	public static String keyToNum(String str) {
		if (str.equals("zero")) {
			return "0";
		} else if (str.equals("one")) {
			return "1";
		} else if (str.equals("two")) {
			return "2";
		} else if (str.equals("three")) {
			return "3";
		} else if (str.equals("four")) {
			return "4";
		} else if (str.equals("five")) {
			return "5";
		} else if (str.equals("six")) {
			return "6";
		} else if (str.equals("seven")) {
			return "7";
		} else if (str.equals("eight")) {
			return "8";
		} else if (str.equals("nine")) {
			return "9";
		} else {
			return "";
		}

	}

	/**
	 * 模拟数字转换成字符串
	 * 
	 * @param num
	 * @return
	 */
	public static char[] makeStr(String num) {
		char[] chars = num.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			builder.append(numToString(chars[i]));
		}
		chars = builder.toString().toCharArray();
		Arrays.sort(chars);
		return chars;
	}

	/**
	 * 将字符串转化拆分成数组
	 * 
	 * @param chars
	 * @return
	 */
	public static String[] splitStr(char[] chars) {
		String str = String.valueOf(chars);
		Pattern pattern = Pattern.compile("([a-z])\\1*");
		Matcher matcher = pattern.matcher(str);

		int i = 0;
		String[] strs = new String[15];
		while (matcher.find()) {
			strs[i] = matcher.group(0);
			i++;
		}
		return strs;
	}

	/**
	 * 将char[]装进map a aaa n nnnnn
	 * 
	 * @param strs
	 * @return
	 */
	public static void makeMap(String[] strs) {

		for (int i = 0; i < strs.length; i++) {
			if (strs[i] != null) {
				char[] chars = strs[i].toCharArray();
				charMap.put(chars[0], chars);
			}
		}
	}

	public static void restore() {
		//第一次： zero(z) two(w) four(u) six(x) eight(g) 剩下： one three five seven nine
		 // 第二次： one(o) three(r) five(f) seven(s) 剩下： nine
		remove(new char[]{'z','w','u','x','g'},new String[] {"zero","two","four","six","eight"});
		remove(new char[]{'o','r','f','s'},new String[] {"one","three","five","seven"});
		//第三次;判断9的个数
		if(charMap.containsKey('i')){
			for(char c : charMap.get('i')){
				if(c != '0')
				result.append('9');
			}
		}

	}

	public static void remove(char[] key, String[] keyStr) {
		for (int i = 0; i < keyStr.length; i++) {
			if (charMap.containsKey(key[i])) {		
				//有多少个key z的个数
				int times = 0;
				// 取出 zzz说明有三个 0 追加结果 “000...” 
				for (char c : charMap.get(key[i])) {
					if(c != '0'){
						result.append(keyToNum(keyStr[i])); 
						times ++;
					}
				}
				//获取全部字符 z e r o
				char[] keyChars = keyStr[i].toCharArray();
				
				for (int m = 0; m < keyChars.length; m++) {
					//zzz eeeee rrrrr ooooo
					char[] c = charMap.get(keyChars[m]);
					// 去掉 三个z 三个e 三个r 三个o
					for( int z = 0 ; z < times; z++){
						for (int k = 0; k < c.length; k++) {
							if (c[k] != '0') {
								c[k] = '0';
								break;
							}
						}
					}
					
					//=======检查数组是否为空============
					boolean isEmpty = true;
					for(int n = 0 ; n< c.length ; n ++){
						if(c[n] != '0' ){
							isEmpty = false;
						}
					}
					if(isEmpty){
						charMap.remove(keyChars[m]);
					}
					//==============================
				}
			}
			
		}
	}

	public static void main(String[] args) {
		char[] mkStr = makeStr("011176234599");
		System.out.println(String.valueOf(mkStr));
		String[] strs = splitStr(mkStr);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		makeMap(strs);
//		System.out.println(charMap.get('e'));
//		System.out.println(charMap.get('h'));
//		System.out.println(charMap.get('n'));
//		System.out.println(charMap.get('o'));
//		System.out.println(charMap.get('r'));
//		System.out.println(charMap.get('t'));
//		System.out.println(charMap.get('w'));
		restore();
		System.out.println("result=="+result.toString());
	}

}
