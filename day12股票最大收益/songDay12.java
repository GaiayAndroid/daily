package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shares {
	// public static int[] data = {1,6,9,8,7,10};
	public static int[] data = { 9, 1, 2, 6, 9, 8, 7, 10 };

	public static int getProfit(int[] array) {
		List<Integer> data = asList(array);
		return getMaxMargin(kickBothSide(kickConsecutive(data)));
	}

	/**
	 * 第一步： 首先将数据剔除连续的 ++ -- ，最后获得 +-+-+-的形式
	 */
	public static List<Integer> kickConsecutive(List<Integer> data) {
		for (int i = 0; i < data.size() - 2; i++) {
			// +
			if (data.get(i) < data.get(i + 1)) {
				// ++ 剔除
				if (data.get(i + 1) < data.get(i + 2)) {
					data.remove(i + 1);
					// 为了判断出现 +++ 的情况
					i--;
				}
			} // -
			else {
				if (data.get(i + 1) > data.get(i + 2)) {
					data.remove(i + 1);
					// 为了判断出现 +++ 的情况
					i--;
				}
			}
		}
		return data;
	}

	/**
	 * 第二步： 剔除两边，前边为+开头， 末尾也为+ 即 [3,4,X,X,5,6]
	 * 经过这一步得到的list： 以+开头， 以+结尾，并且长度为一个偶数值
	 */
	public static List<Integer> kickBothSide(List<Integer> data) {
		if (data.size() >= 3) {
			// 剔除首位
			if (data.get(0) > data.get(1)) {
				data.remove(0);
			}
			// 剔除末位
			if (data.get(data.size() - 1) < data.get(data.size() - 2)) {
				data.remove(data.size() - 1);
			}
		}
		return data;
	}

	/**
	 * 第三步：
	 * 每次取后面两个点（一个较小值和一个较大值），与前面两个点构成四边形，取最大长度的线段，
	 * 然后用这个最大长度的线段与后两个点再构成四边形，获取最大的对角线
	 * 依次比较完成后就可以得到最大长度的线段
	 * 
	 */
	public static int getMaxMargin(List<Integer> data) {
		if (data.size() >= 4) {
			int j = 0, k = 1;
			for(int i = 0 ; i < data.size()-2; i=i+2){
				int left = data.get(k) - data.get(j);
				int mid = data.get(i+3) - data.get(j);
				int right = data.get(i+3) -data.get(i+2);
				
				if(left> mid){
					//left 最大
					if(left>right){
						j = j;
						k = k;
					}//right 最大
					else{
						j = i+2;
						k = i+3;
					}
				}else{
					//mid最大
					if(mid > right){
						//j = j;
						k = i+3;
					}//right 最大
					else{
						j = i+2;
						k = i+3;
					}
				}
			}
			return data.get(k) - data.get(j);
		}
		return data.get(1) - data.get(0);
	}

	public static List<Integer> asList(int[] data) {
		List<Integer> list = new ArrayList<>();
		for (int i : data) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
			System.out.println(getProfit(data));
//		List<Integer> list = asList(data);
//		kickConsecutive(list);
//		for(int i = 0 ; i < list.size() ; i++){
//			System.out.println(list.get(i));
//		}
//		kickBothSide(list);
//		for(int i = 0 ; i < list.size() ; i++){
//			System.out.println(list.get(i));
//		}
//		getMaxMargin(list);
	}
}
