package a2adept;

import java.util.Scanner;

public class A2Adept {

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
			if (outs[i] < 10) {
				System.out.println(" " + outs[i] + ":" + outputs[i]);
			} else {
				System.out.println(outs[i] + ":" + outputs[i]);
			}
		}

	}
}
