package com.task6.multithreading;

public class TwoThreadTest {
	public static void main(String[] args) {
		MatrixRunnable matrixRun = new MatrixRunnable(new Matrix());
        Thread oneThread = new Thread(matrixRun, "Первый поток");
        Thread twoThread = new Thread(matrixRun, "Второй поток");

        oneThread.start();
        twoThread.start();
    }
	}

