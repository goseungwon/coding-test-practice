package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon18808 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int height;
	static int width;
	static int stickerAmount;
	static boolean[][] map;
	static Queue<boolean[][]> stickers = new LinkedList<>();

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		stickerAmount = Integer.parseInt(st.nextToken());
		map = new boolean[height][width];

		for (int i=0; i<stickerAmount; i++) {
			st = new StringTokenizer(br.readLine());
			int stickerHeight = Integer.parseInt(st.nextToken());
			int stickerWidth = Integer.parseInt(st.nextToken());
			boolean[][] sticker = new boolean[stickerHeight][stickerWidth];

			for (int j=0; j<stickerHeight; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0; k<stickerWidth; k++) {
					if (st.nextToken().equals("1")) sticker[j][k] = true;
				}
			}
			stickers.add(sticker);
		}
	}

	private static void solve() {
		while (!stickers.isEmpty()) {
			boolean[][] sticker = stickers.poll();

			for (int i=0; i<4; i++) {
				if(isAttachable(sticker)) break;
				sticker = turn(sticker);
			}
		}
	}

	private static boolean isAttachable(boolean[][] sticker) {
		//붙이기 성공하면 true
		int stickerHeight = sticker.length;
		int stickerWidth = sticker[0].length;

		for (int i=0; i<=height-stickerHeight; i++) {
			for (int j=0; j<=width-stickerWidth; j++) {
				if (attach(sticker,i,j)) return true;
			}
		}
		return false;
	}

	private static boolean attach(boolean[][] sticker, int y, int x) {
		for (int i=0; i<sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (map[y+i][x+j] && sticker[i][j]) return false;
			}
		}

		for (int i=0; i<sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j]) map[y+i][x+j] = true;
			}
		}
		return true;
	}

	private static boolean[][] turn(boolean[][] sticker) {
		//90도 회전해서 반환
		int height = sticker.length;
		int width = sticker[0].length;
		boolean[][] turnedSticker = new boolean[width][height];

		for (int i = 0; i< height; i++) {
			for (int j = 0; j< width; j++) {
				turnedSticker[j][height-i-1] = sticker[i][j];
			}
		}
		return turnedSticker;
	}

	private static void print() {
		int result = 0;
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (map[i][j]) result++;
			}
		}

		System.out.println(result);
	}
}
