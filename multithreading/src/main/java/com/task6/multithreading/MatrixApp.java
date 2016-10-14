package com.task6.multithreading;

class Matrix {

	Fill fill = new Fill();

	int[][] matr1 = fill.fillMatrix(10);
	int[][] matr2 = fill.fillMatrix(10);
	int[][] resultMatr = new int[matr1.length][matr2[0].length];
	int[][] flagMatr = new int[matr1.length][matr2[0].length];

}

class MatrixRunnable implements Runnable {
	private Matrix matrix;

	MatrixRunnable(Matrix matrix) {
		this.matrix = matrix;
	}

	public void run() {
		int[] myMatr;
		while ((myMatr = findEmptyElement()) != null) {
			multiply(myMatr[0], myMatr[1]);
		}
	}

	public int[] findEmptyElement() {
		System.out.println(Thread.currentThread().getName()
				+ " findEmptyElement -  started");
		synchronized (matrix.flagMatr) {

			for (int i = 0; i < matrix.matr1.length; i++) {

				for (int j = 0; j < matrix.matr2[0].length; j++) {

					if (matrix.flagMatr[i][j] == 0) {
						matrix.flagMatr[i][j] = 1;
						int mas[] = new int[2];
						mas[0] = i;
						mas[1] = j;

						System.out.println(Thread.currentThread().getName()
								+ " findEmptyElement - finished" + " " + mas[0]
								+ "," + mas[1]);
						return mas;
					}

				}

			}
		}
		System.out.println(Thread.currentThread().getName()
				+ " findEmptyElement - finished [not found]");

		return null;
	}

	public void multiply(int index1, int index2) {
		System.out.println(Thread.currentThread().getName()
				+ " multiply  started " + index1 + "," + index2);
		int element = 0;

		for (int k = 0; k < matrix.matr2[0].length; k++) {
			int newElement = matrix.matr1[index1][k] * matrix.matr2[k][index2];
			element += newElement;
		}

		matrix.resultMatr[index1][index2] = element;

		for (int i = 0; i < 10000000; i++) {
			// do nothing for longer method work
		}

		System.out.println(Thread.currentThread().getName()
				+ " multiply finished " + index1 + "," + index2);
	}
}
