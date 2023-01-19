package samsungdx.week1.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class W1D2NO04 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int textCase=1; textCase<=10; textCase++) {
			int listLength = sc.nextInt();
			ArrayList<String> list = new ArrayList<>();

			for (int i=0; i<listLength; i++) list.add(sc.next());

			int commandCase = sc.nextInt();

			for (int i=0; i<commandCase; i++) {
				char command = sc.next().charAt(0);

				switch (command) {
					case 'I' :
						int IX = sc.nextInt();
						int IY = sc.nextInt();
						for (int j = 0; j < IY; j++) {
							list.add(IX + j, sc.next());
						}
					break;
					case 'D' :
						int DX = sc.nextInt();
						int DY = sc.nextInt();
						for (int j = 0; j < DY; j++) {
							list.remove(DX);
						}
					break;
					case 'A' :
						int AY = sc.nextInt();
						for (int a = 0; a < AY; a++) {
							list.add(sc.next());
						}
					break;
				}
			}
			sb.append("#"+textCase+" ");
			for (int i=0; i<10; i++) sb.append(list.get(i)+ " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
