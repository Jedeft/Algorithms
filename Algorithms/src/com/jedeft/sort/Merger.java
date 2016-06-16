package com.jedeft.sort;

import java.util.Arrays;

/**
 * 归并排序算法（递归），时间复杂度为Θ(nlg n)
 * @author Jedeft
 * @date 2016年6月16日 上午10:16:51
 */
public class Merger {
	private static void merge(Integer[] A, int p, int q, int r) {
		//两个子数组循环执行次数
		int n1 = q - p + 1;
		int n2 = r - q;
		//初始化两个子数组（此处子数组已被排序好）
		Integer[] L = new Integer[n1];
		Integer[] R = new Integer[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + j + 1];
		}
		//排序两个已经被排序好的子数组
		int i = 0;
		int j = 0;
		int k = p;
		//此处有多少个数，判断多少次，时间效率为n
		while ( k <= r ) {
			//此处不用哨兵，而是在判断一个子数组遍历到末尾后，将另一子数组的所有数据放入到数组中去
			if (i >= L.length) {
				for (; j < R.length; j ++) {
					A[k ++] = R[j];
				}
				break;
			}
			if (j >= R.length) {
				for (; i < L.length; i ++) {
					A[k ++] = L[i];
				}
				break;
			}
			if (L[i] <= R[j]) {
				A[k] = L[i ++];
			} else {
				A[k] = R[j ++];
			}
			k++;
		}
	}
	
	private static void mergeSort(Integer[] A, int p, int r) {
		if (p < r) {
			//此处递归，不断的将数组拆分为两个子数组，直到拆分到子数组中包含为至少2个元素。
			int q = (p + r) / 2 ;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = {7, 3, 4, 22, 33, 56, 11, 8, 9, 10, 1, 87, 98, 110};
		System.out.println(Arrays.asList(array).toString());
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.asList(array).toString());
	}
}
