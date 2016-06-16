package com.jedeft.sort;

import java.util.Arrays;

/**
 * 插入排序算法（递归），时间复杂度为Θ（n²）
 * @author Jedeft
 * @date 2016年6月16日 上午10:10:40
 */
public class Insert {
	private static void insert(Integer[] A, int p, int r) {
		if (p < r) {
			//不断的把数组拆分为长度-1的子数组
			int result = r - 1;
			insert(A, p, result);
			int key = A[r];
			int i = r - 1;
			//将子数组进行排序，顺序为，2个数字排序 -> 2个顺序的数字+另一个数字排序 -> 3个顺序的数字+另一个数字排序
			while (i >= 0 && A[i] > key) {
				A[i + 1] = A[i];
				i--;
 			}
			A[i + 1] = key;
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = {7, 3, 4, 22, 33, 56, 11, 8, 9, 10, 1, 87, 98, 110};
		System.out.println(Arrays.asList(array).toString());
		insert(array, 0, array.length - 1);
		System.out.println(Arrays.asList(array).toString());
	}
}
