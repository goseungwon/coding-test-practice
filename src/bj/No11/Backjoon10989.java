package bj.No11;

import java.io.*;
import java.util.Arrays;

public class Backjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//
//        for (int i=0; i<n; i++){
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] > arr[j]) {
//                    swap(arr, i, j);
//                }
//            }bw.write(arr[i]+"\n");
//        }
//        bw.flush();
//        bw.close();   내가 짠 알고리즘(기본정렬)


        //sort(arr);    피봇정렬 퍼옴

        Arrays.sort(arr); // 라이브러리
        for (int i=0; i<n; i++)
            bw.write(arr[i]+"\n");
        bw.flush();
        bw.close();
    }

        public static void sort(int[] a) {
            l_pivot_sort(a, 0, a.length - 1);
        }

        /**
         *  왼쪽 피벗 선택 방식
         * @param a		정렬할 배열
         * @param le	현재 부분배열의 왼쪽
         * @param ri	현재 부분배열의 오른쪽
         */
        private static void l_pivot_sort(int[] a, int le, int ri) {

            /**
             *  le가 ri보다 크거나 같다면 정렬 할 원소가
             *  1개 이하이므로 정렬하지 않고 return한다.
             */
            if(le >= ri) {
                return;
            }

            /**
             * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
             * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
             *
             * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
             * 분할 정복을 해준다.
             *
             * [과정]
             *
             * Partitioning:
             *
             *   a[left]          left part              right part
             * +---------------------------------------------------------+
             * |  pivot  |    element <= pivot    |    element > pivot   |
             * +---------------------------------------------------------+
             *
             *
             *  result After Partitioning:
             *
             *         left part          a[le]          right part
             * +---------------------------------------------------------+
             * |   element <= pivot    |  pivot  |    element > pivot    |
             * +---------------------------------------------------------+
             *
             *
             *  result : pivot = le
             *
             *
             *  Recursion:
             *
             * l_pivot_sort(a, le, pivot - 1)     l_pivot_sort(a, pivot + 1, ri)
             *
             *         left part                           right part
             * +-----------------------+             +-----------------------+
             * |   element <= pivot    |    pivot    |    element > pivot    |
             * +-----------------------+             +-----------------------+
             * le                pivot - 1        pivot + 1                 ri
             *
             */
            int pivot = partition(a, le, ri);

            l_pivot_sort(a, le, pivot - 1);
            l_pivot_sort(a, pivot + 1, ri);
        }



        /**
         * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
         *
         * @param a		정렬 할 배열
         * @param left	현재 배열의 가장 왼쪽 부분
         * @param right	현재 배열의 가장 오른쪽 부분
         * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
         */
        private static int partition(int[] a, int left, int right) {

            int lo = left;
            int hi = right;
            int pivot = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정

            // lo가 hi보다 작을 때 까지만 반복한다.
            while(lo < hi) {

                /**
                 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
                 * 찾을 떄 까지 hi를 감소시킨다.
                 */
                while(a[hi] > pivot && lo < hi) {
                    hi--;
                }

                /**
                 * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
                 * 찾을 떄 까지 lo를 증가시킨다.
                 */
                while(a[lo] <= pivot && lo < hi) {
                    lo++;
                }

                // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
                swap(a, lo, hi);
            }


            /**
             *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와
             *  lo가 가리키는 원소를 바꾼다.
             */
            swap(a, left, lo);

            // 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo를 반환한다.
            return lo;
        }

        private static void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
}
