package com.task6.multithreading;

public class Fill {
	
	public int[][] fillMatrix(int length) {
		int[][] matrix = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = (int) (Math.random() * 9);
			}
		}
		return matrix;
	}
}
