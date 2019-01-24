package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {

		int columns = s.nextInt();
		int rows = s.nextInt();

		int[][] input = new int[columns][rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				input[i][j] = s.nextInt();
			}
		}

		int min = input[0][0];
		boolean first_time = true;
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (first_time) {
					first_time = false;
					min = input[i][j];
				} else if (input[i][j] <= min) {
					min = input[i][j];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (input[i][j] >= max) {
					max = input[i][j];
				}
			}
		}

		int totalSum = 0;
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				totalSum = totalSum + input[i][j];
			}
		}

		double avg = (double) totalSum / (columns * rows);

		String[][] output = new String[columns][rows];

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				if (input[i][j] >= 0 && input[i][j] <= 9) {
					output[i][j] = "#";
				} else if (input[i][j] >= 10 && input[i][j] <= 19) {
					output[i][j] = "M";
				} else if (input[i][j] >= 20 && input[i][j] <= 29) {
					output[i][j] = "X";
				} else if (input[i][j] >= 30 && input[i][j] <= 39) {
					output[i][j] = "D";
				} else if (input[i][j] >= 40 && input[i][j] <= 49) {
					output[i][j] = "<";
				} else if (input[i][j] >= 50 && input[i][j] <= 59) {
					output[i][j] = ">";
				} else if (input[i][j] >= 60 && input[i][j] <= 69) {
					output[i][j] = "s";
				} else if (input[i][j] >= 70 && input[i][j] <= 79) {
					output[i][j] = ":";
				} else if (input[i][j] >= 80 && input[i][j] <= 89) {
					output[i][j] = "-";
				} else if (input[i][j] >= 90 && input[i][j] <= 99) {
					output[i][j] = " ";
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (j != columns - 1) {
					System.out.print(output[j][i]);
				} else {
					System.out.println(output[j][i]);
				}
			}
		}

		System.out.println("Min value = " + min);
		System.out.println("Max value = " + max);
		System.out.println("Average value = " + avg);

	}
}
