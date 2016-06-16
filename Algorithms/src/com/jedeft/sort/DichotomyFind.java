package com.jedeft.sort;

import java.util.Arrays;

/**
 * ���ַ�����������õ�����
 * @author Jedeft
 * @date 2016��6��16�� ����10:07:48
 */
public class DichotomyFind {
	
	//��һ��׾�Ӵ���
//	private static boolean find(Integer[] A, int p, int r, int num) {
//		// ������ַ����ҵ����ֻ�������������޷��������֣���ô�����������ֱ��Ŀ���������Ƚ�
//		if (r - p == 1) {
//			return A[p] == num || A[r] == num ? true : false;
//		} else {
//			int mid = (p + r) / 2;
//			if (A[mid] == num) {
//				return true;
//			} else if (A[mid] < num) {
//				return find(A, mid, r, num);
//			} else {
//				return find(A, p, mid, num);
//			}
//		}
//	}
	
	//�ڶ���������Ŵ���
	private static boolean find(Integer[] A, int p, int r, int num) {
		if (p > r) {
			return false;
		} 
		int mid = (p + r) / 2;
		if (A[mid] == num) {
			return true;
		} else if (A[mid] < num) {
			return find(A, mid + 1, r, num);
		} else {
			return find(A, p, mid - 1, num);
		}
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 3, 4, 7, 8, 9, 10, 11, 22, 33, 56, 87, 98, 110 };
		System.out.println(Arrays.asList(array).toString());
		System.out.println(find(array, 0, array.length - 1, 110));
	}
}
