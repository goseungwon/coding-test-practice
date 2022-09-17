public class CodingTest3 {
    static boolean[][] visited;
    static int[][] field;
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N=9;
        int[] P = {8,5};
        int[][] mine = {{1,2}, {2,6},{3,4},{3,8},{4,9},{5,4},{5,8},{6,7},{7,2},{9,1}};
        System.out.println(sol.solution(N, mine, P));

    }

    static class Solution{
        public int solution(int N, int[][] mine, int[] P) {
            field = new int[N+1][N+1];
            visited = new boolean[N+1][N+1];

            for (int i=0; i<mine.length; i++){
                int a = mine[i][0];
                int b = mine[i][1];

                field[a][b] = 9999;
                int left=a;
                int right=a;
                int top=b;
                int bottom=b;

                if (a>1) left--;
                if (a<N) right++;
                if (b>1) top--;
                if (b<N) bottom++;

                field[left][top]++;
                field[left][b]++;
                field[left][bottom]++;
                field[a][top]++;
                field[a][bottom]++;
                field[right][top]++;
                field[right][b]++;
                field[right][bottom]++;
            }

            int x = P[0];
            int y = P[1];
            near(x, y, N);


            int answer=0;
            for (int i=1; i<field.length; i++){
                for (int j=1; j<field[i].length; j++){
                    if (visited[i][j]) answer++;
                }
            }

            return answer;
        }

        public static void near(int a, int b, int N) {
            if (visited[a][b]) return;
            visited[a][b]=true;
            if (field[a][b]==0){

                int left = a;
                int right = a;
                int top = b;
                int bottom = b;

                if (a > 1) left--;
                if (a < N) right++;
                if (b > 1) top--;
                if (b < N) bottom++;

                near(left, top, N);
                near(left, b, N);
                near(left, bottom, N);
                near(a, top, N);
                near(a, bottom, N);
                near(right, top, N);
                near(right, b, N);
                near(right, bottom, N);
            }
        }
    }
}
