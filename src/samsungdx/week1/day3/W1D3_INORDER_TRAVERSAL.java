package samsungdx.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W1D3_INORDER_TRAVERSAL {
    static char[] tree;
    static int treeLength;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase=1; testCase<=10;testCase++) {
            treeLength = Integer.parseInt(br.readLine());
            tree = new char[treeLength+1];

            for (int i=1; i<=treeLength; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
            }
            sb.append("#"+testCase+" ");
            inOrder(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void inOrder(int index) {
        if (index>treeLength) return;
        inOrder(2*index);
        sb.append(tree[index]);
        inOrder(2*index+1);
    }

}
