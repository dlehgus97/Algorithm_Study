/*
팩토리얼 2 성공
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	1024 MB	30730	14356	12870	48.031%
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 N!을 출력한다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long num =1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fac(N));
    }
    public static long Fac (int N) {

        if(N == 0){
            return num;
        }
        num *= N;
          return Fac(N-1);
        }
}
