package barkingDog.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Backjoon11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int high = sc.nextInt();

		int moves = (int)(Math.pow(2, high) - 1);
		bw.write(moves +"\n");
		recursive(1, 3, high);
		bw.close();
	}

	public static void recursive (int now, int to, int height) throws IOException {
		if (--height == 0) {
			bw.write(now + " " + to + "\n");
			return;
		}
		recursive(now, 6-now-to, height);
		bw.write(now + " " + to + "\n");
		recursive(6-now-to, to, height);
	}

}
