package com.jedeft.sort;

import java.util.Arrays;


/**
 * 选择排序算法（迭代），时间复杂度为Θ(n²)
 * @author Jedeft
 * @date 2016年6月16日 上午10:15:28
 */
public class Choice {
	public static void main(String[] args) {
		Integer[] A = {6,3,5,2,1,9,11,34,88,43,65,0};
		for (int i = 0; i < A.length-1 ; i++) {
			Integer minI = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[minI] > A[j]) {
					minI = j;
				}
			}
			if (minI != i) {
				Integer temp = A[i];
				A[i] = A[minI];
				A[minI] = temp;
			}
		}
		System.out.println(Arrays.asList(A).toString());
	}
}
