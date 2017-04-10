package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class day05 {

	public static String a = "pwwwadwgkew";
	public static String b = "bbbbb";
	public static String c = "abcabcbb";
	public static String d = "pwwkew";


	/**
	 * 解法二：利用set值不重复的特点 ，缺点 输出字符串无序
	 * 
	 * 
	 * @param str
	 * @return
	 */
	public static String getNonRepet(String str) {
		char[] chars = str.toCharArray();
		System.out.println(Arrays.toString(chars));
		HashSet<Character> room = new HashSet<>();

		StringBuilder builderTemp = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			System.out.println("准备添加： " + chars[i]);
			// 发现重复的
			if (!room.add(chars[i])) {
				System.out.println(" 发现重复的" + chars[i]);
				System.out.println("builderLength == " + builderTemp.length() + builderTemp.toString()
						+ "    roomSize==" + room.size());
				if (builderTemp.length() < room.size()) {
					builderTemp = new StringBuilder().append(cast(room.toArray(new Character[] {})));
				}
				room.clear();
				if (chars[i] == chars[i - 1]) {
					room.add(chars[i]);
				}
				System.out.println(" clear 后room" + Arrays.toString(room.toArray(new Character[] {})));
			}
			System.out.println("builder ==" + builderTemp);
			System.out.println("room == " + Arrays.toString(room.toArray(new Character[] {})));
			System.out.println();
		}
		return room.size() > builderTemp.length()
				? new StringBuilder().append(cast(room.toArray(new Character[] {}))).toString()
				: builderTemp.toString();
	}

	public static char[] cast(Character[] chars) {
		char[] value = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			value[i] = chars[i];
		}
		return value;
	}

	/**
	 * 利用HashMap不能重复key的特点（set值不重复），然后排序 缺点：当出现多个长度相同的串时 只能得到一个答案
	 * 
	 * @param str
	 * @return
	 */
	public static String getNonRepet2(String str) {
		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			map.put(chars[i], i);
		}
		Integer[] indexs = (Integer[]) map.values().toArray(new Integer[] {});
		Arrays.sort(indexs);

		int start = 0;
		int end = 0;
		int indexStart = 0;
		int len = 0;

		for (int i = 0; i < indexs.length - 1; i++) {
			if (indexs[i + 1] - indexs[i] == 1) {
				end = i + 1;
			} else {
				if (end - start > len) {
					len = end - start;
					indexStart = start;
				}
				start = end = i + 1;
			}
		}
		if (end - start > len) {
			return Arrays.toString(Arrays.copyOfRange(indexs, start, end + 1));
		} else {
			return Arrays.toString(Arrays.copyOfRange(indexs, indexStart, len + 1));
		}
	}

	/**
	 * 同上  OK  
	 * 
	 * 缺点 [a, b, c, a, b, c, b, b]只有一个结果
	 */
	public static String[] getNonRepet3(String str) {
		char[] chars = str.toCharArray();
		System.out.println(Arrays.toString(chars));
		// 存放结果
		HashSet<String> results = new HashSet<>();

		HashSet<Character> room = new HashSet<>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (!room.add(chars[i])) {
				room.clear();
				room.add(chars[i]);
				results.add(builder.toString());
				builder = new StringBuilder();
				builder.append(chars[i]);
				continue;
			}
			builder.append(chars[i]);
		}
		results.add(builder.toString());
		String[] values = results.toArray(new String[] {});
		System.out.println("排序前： "+Arrays.toString(values));
		Arrays.sort(values, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println("排序后：  "+Arrays.toString(values));
		for (int i = values.length - 1; i >= 1; i--) {
			if (values[i].length() > values[i - 1].length()) {
					values =Arrays.copyOfRange(values,i, values.length);	
					break;
			}
		}
		System.out.println("最终结果 == "+Arrays.toString(values));
		return values;

	}

	public static void main(String[] args) {
		// System.out.println(getLength(d));
		// System.out.println(getNonRepet(a));
		// System.out.println(getNonRepet2(a));
		System.out.println(getNonRepet3(d));

	}
}
