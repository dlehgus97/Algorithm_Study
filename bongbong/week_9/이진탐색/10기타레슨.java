/*
https://www.acmicpc.net/problem/2343
기타 레슨

문제
강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다.
블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다.
순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다.
즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.

강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다.
오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다.
이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
단, M개의 블루레이는 모두 같은 크기이어야 한다.

강토의 각 강의의 길이가 분 단위(자연수)로 주어진다.
이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다.
다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다.
각 강의의 길이는 10,000분을 넘지 않는다.

출력
첫째 줄에 가능한 블루레이 크기중 최소를 출력한다.

예제 입력 1
9 3
1 2 3 4 5 6 7 8 9
예제 출력 1
17
힌트
강의는 총 9개이고, 블루레이는 총 3개 가지고 있다.

1번 블루레이에 1, 2, 3, 4, 5, 2번 블루레이에 6, 7, 3번 블루레이에 8, 9 를 넣으면 각 블루레이의 크기는 15, 13, 17이 된다.
블루레이의 크기는 모두 같아야 하기 때문에, 블루레이의 크기는 17이 된다.
17보다 더 작은 크기를 가지는 블루레이를 만들 수 없다.
 */

package week_9.이진탐색.기타레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] lectures;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        lectures = new int[n];
        int lectureMaxSize = 0;
        int lectureSum = 0;
        // 강의 분할 시작점(letureMaxSize) = 제일 긴 강의 길이 크기의 블루레이면 강의가 무조건 하나씩은 담김
        // 강의 분할 종료점(letureSum) = 모든 강의 길이 합인 크기에 블루레이에 있는 강의 다담기 가능
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            lectureSum += lectures[i];
            if (lectureMaxSize < lectures[i]) {
                lectureMaxSize = lectures[i];
            }
        }
        System.out.println(size(lectureMaxSize,lectureSum,m));

    }

    public static int size(int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (lectureCount(mid) > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // 가능한 블루레이 크기 중 최소
    }

    private static int lectureCount(int mid) {
        int cnt = 1;
        int remain = mid;
        for (int i = 0; i < n; i++) {
            if (remain < lectures[i]) {
                // 블루레이 크기 mid 보다 담고자 하는 강의 크기가 크면 새로운 블루레이에 담는다
                remain = mid;
                cnt++;
            }
            remain -= lectures[i];

        }
        return cnt;
    }

}
