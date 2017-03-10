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
	 * ��һ���� ���Ƚ������޳������� ++ -- ������� +-+-+-����ʽ
	 */
	public static List<Integer> kickConsecutive(List<Integer> data) {
		for (int i = 0; i < data.size() - 2; i++) {
			// +
			if (data.get(i) < data.get(i + 1)) {
				// ++ �޳�
				if (data.get(i + 1) < data.get(i + 2)) {
					data.remove(i + 1);
					// Ϊ���жϳ��� +++ �����
					i--;
				}
			} // -
			else {
				if (data.get(i + 1) > data.get(i + 2)) {
					data.remove(i + 1);
					// Ϊ���жϳ��� +++ �����
					i--;
				}
			}
		}
		return data;
	}

	/**
	 * �ڶ����� �޳����ߣ�ǰ��Ϊ+��ͷ�� ĩβҲΪ+ �� [3,4,X,X,5,6]
	 * ������һ���õ���list�� ��+��ͷ�� ��+��β�����ҳ���Ϊһ��ż��ֵ
	 */
	public static List<Integer> kickBothSide(List<Integer> data) {
		if (data.size() >= 3) {
			// �޳���λ
			if (data.get(0) > data.get(1)) {
				data.remove(0);
			}
			// �޳�ĩλ
			if (data.get(data.size() - 1) < data.get(data.size() - 2)) {
				data.remove(data.size() - 1);
			}
		}
		return data;
	}

	/**
	 * ��������
	 * ÿ��ȡ���������㣨һ����Сֵ��һ���ϴ�ֵ������ǰ�������㹹���ı��Σ�ȡ��󳤶ȵ��߶Σ�
	 * Ȼ���������󳤶ȵ��߶�����������ٹ����ı��Σ���ȡ���ĶԽ���
	 * ���αȽ���ɺ�Ϳ��Եõ���󳤶ȵ��߶�
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
					//left ���
					if(left>right){
						j = j;
						k = k;
					}//right ���
					else{
						j = i+2;
						k = i+3;
					}
				}else{
					//mid���
					if(mid > right){
						//j = j;
						k = i+3;
					}//right ���
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
