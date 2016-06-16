package com.jedeft.sort;

import java.util.Arrays;

/**
 * 确定在n个元素的任何排列中逆序对数量的算法（递归），该算法参考与归并算法。时间复杂度Θ(nlg n)
 * 逆序对：假设A[1...n]是一个有n个不同数的数组。若i<j且A[i] > A[j]，则对偶(i, j)称为A的一个逆序对(inversion)
 * @author Jedeft
 * @date 2016年6月16日 上午10:26:02
 */
public class Inversion {
	
	//逆序对数量
	private static int num = 0;
	
	private static void mergeSort(Integer[] A,int p, int r) {
		if (p < r) {
			//此处递归，不断的将数组拆分为两个子数组，直到拆分到子数组中包含为至少2个元素。
			int q = (p + r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			num += merge(A, p, q, r);
		} 
	}
	
	private static int merge(Integer[] A,int p, int q, int r) {
		//两个子数组循环执行次数
		int n1 = q - p + 1;
		int n2 = r - q ;
		//初始化两个子数组
		Integer[] L = new Integer[n1];
		Integer[] R = new Integer[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = A[q + 1 + i];
		}
		int count = 0;
		//此处比较两个子数组中的值，总是L(左)数组中的值大于R(右)数组中的值，此时在数组A中，必定是i<j，那么count++
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if (L[i] > R[j]) {
					count ++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Integer[] array = {8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println(Arrays.asList(array).toString());
		mergeSort(array, 0, array.length - 1);
		System.out.println(num);
	}
}
