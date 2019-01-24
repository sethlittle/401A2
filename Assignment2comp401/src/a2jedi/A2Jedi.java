package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		int binWidth = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();

		double total = 0.0;
		int[][] input = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (s.hasNext()) {
					input[i][j] = s.nextInt();
					total++;
				}
			}
		}

		int bins = (int) Math.ceil(100.0 / binWidth);
		int[] bin = new int[bins];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				for (int b = 0; b < bins; b++) {
					if (input[i][j] >= (b * binWidth) && input[i][j] < ((b + 1) * binWidth)) {
						bin[b] = bin[b] + 1;
					} else if (b == bins && input[i][j] > (b * binWidth) && input[i][j] <= ((b + 1) * binWidth)) {
						bin[b] = bin[b] + 1;
					}
				}
			}
		}

		double[] percents = new double[bins];
		for (int i = 0; i < bins; i++) {
			percents[i] = 100 * ((double) bin[i] / total);
		}

		int[] perc = new int[bins];
		for (int i = 0; i < bins; i++) {
			perc[i] = (int) (percents[i] + 0.5);
		}

		int maxPerc = perc[0];
		for (int i = 0; i < bins; i++) {
			if (perc[i] > maxPerc) {
				maxPerc = perc[i];
			}
		}

		String[] outputs = new String[bins];
		for (int i = 0; i < bins; i++) {
			outputs[i] = "";
		}

		for (int i = 0; i < bins; i++) {
			for (int j = 0; j < perc[i]; j++) {
				outputs[i] = outputs[i] + "*";
			}
		}

		int[] outs = new int[bins];
		for (int i = 0; i < bins; i++) {
			outs[i] = i * binWidth;
		}

		String[][] verticals = new String[bins][maxPerc + 3];

		for (int i = 0; i < bins; i++) {
			verticals[i][0] = secondInt(outs[i]);
			verticals[i][1] = firstInt(outs[i]);
			verticals[i][2] = "-";
			for (int j = 3; j < maxPerc + 3; j++) {
				if (outputs[i].length() >= j - 2) {
					verticals[i][j] = "*";
				} else {
					verticals[i][j] = " ";
				}
			}
		}

		for (int i = 0; i < maxPerc + 3; i++) {
			for (int j = 0; j < bins; j++) {
				if (j == bins - 1) {
					System.out.println(verticals[j][maxPerc + 2 - i]);
				} else {
					System.out.print(verticals[j][maxPerc + 2 - i]);
				}
			}
		}

	}

	private static String firstInt(int input) {
		if (input < 100) {
			if (input < 10) {
				return " ";
			} else {
				if (input < 20) {
					return "1";
				} else if (input < 30) {
					return "2";
				} else if (input < 40) {
					return "3";
				} else if (input < 50) {
					return "4";
				} else if (input < 60) {
					return "5";
				} else if (input < 70) {
					return "6";
				} else if (input < 80) {
					return "7";
				} else if (input < 90) {
					return "8";
				} else {
					return "9";
				}
			}
		}
		throw new RuntimeException("inputs cannot be greater than 99");
	}

	private static String secondInt(int input) {
		if (input < 100) {
			if (input < 10) {
				return "" + input;
			} else {
				if (input < 20) {
					return "" + (input - 10);
				} else if (input < 30) {
					return "" + (input - 20);
				} else if (input < 40) {
					return "" + (input - 30);
				} else if (input < 50) {
					return "" + (input - 40);
				} else if (input < 60) {
					return "" + (input - 50);
				} else if (input < 70) {
					return "" + (input - 60);
				} else if (input < 80) {
					return "" + (input - 70);
				} else if (input < 90) {
					return "" + (input - 80);
				} else {
					return "" + (input - 90);
				}
			}
		}
		throw new RuntimeException("inputs cannot be greater than 99");
	}

}