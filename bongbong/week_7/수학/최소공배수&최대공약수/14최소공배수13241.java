/*
https://www.acmicpc.net/problem/13241
최소공배수
문제
정수 B에 0보다 큰 정수인 N을 곱해 정수 A를 만들 수 있다면, A는 B의 배수이다.

예:

10은 5의 배수이다 (5*2 = 10)
10은 10의 배수이다(10*1 = 10)
6은 1의 배수이다(1*6 = 6)
20은 1, 2, 4,5,10,20의 배수이다.
다른 예:

2와 5의 최소공배수는 10이고, 그 이유는 2와 5보다 작은 공배수가 없기 때문이다.
10과 20의 최소공배수는 20이다.
5와 3의 최소공배수는 15이다.
당신은 두 수에 대하여 최소공배수를 구하는 프로그램을 작성 하는 것이 목표이다.

입력
한 줄에 두 정수 A와 B가 공백으로 분리되어 주어진다.

50%의 입력 중 A와 B는 1000(103)보다 작다. 다른 50%의 입력은 1000보다 크고 100000000(108)보다 작다.

추가: 큰 수 입력에 대하여 변수를 64비트 정수로 선언하시오. C/C++에서는 long long int를 사용하고, Java에서는 long을 사용하시오.

출력
A와 B의 최소공배수를 한 줄에 출력한다.

예제 입력 1
1 1
예제 출력 1
1
예제 입력 2
3 5
예제 출력 2
15
예제 입력 3
1 123
예제 출력 3
123
예제 입력 4
121 199
예제 출력 4
24079
 */

package week_7.수학.최소공배수13241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        // 둘 중 작은수를 1씩 감소하면서 A,B에서 나눈 나머지가 둘다 0인 경우
        long min = Math.min(a, b);
        long GCD = 0; //최대공약수
        for (long j = min; j > 0; j--) {
            if (a % j == 0 && b % j == 0) {
                GCD = j;
                break;
            }
        }
        System.out.println(a * b / GCD);
    }

}
