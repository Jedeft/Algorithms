package com.jedeft.sort;

import java.util.Arrays;

/**
 * 二分法查找已排序好的数组
 * @author Jedeft
 * @date 2016年6月16日 上午10:07:48
 */
public class DichotomyFind {
	
	//第一版拙劣代码
//	private static boolean find(Integer[] A, int p, int r, int num) {
//		// 如果二分法查找到最后只留下两个数，无法继续二分，那么把这两个数分别和目标数字做比较
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
	
	//第二版相对优雅代码
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
