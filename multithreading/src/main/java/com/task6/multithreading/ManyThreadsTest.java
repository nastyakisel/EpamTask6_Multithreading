package com.task6.multithreading;

import java.util.ArrayList;

public class ManyThreadsTest {
	public static void main(String[] args) {
		
		
		Matrix matrix = new Matrix();
		MatrixRunnable matrixRun = new MatrixRunnable(matrix);
        
		ArrayList<Thread> arrayThread = new ArrayList<Thread>();
		for(int i = 0; i < Math.pow(matrix.matr1.length, 2)/2; i++) {
			Thread thread = new Thread(matrixRun, i + "й" + " поток");
			arrayThread.add(thread);
        }
	
		for (int j = 0; j < arrayThread.size(); j ++) {
			arrayThread.get(j).start();
		}
		
	}
}
