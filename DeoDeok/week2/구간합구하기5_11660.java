import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/*
문제
N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.

1	2	3	4
2	3	4	5
3	4	5	6
4	5	6	7
여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.

표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

입력
첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)

출력
총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.

예제 입력 1 
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
예제 출력 1 
27
6
64
*/
public class Main {
	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   int size = Integer.parseInt(st.nextToken());
	   int repeat = Integer.parseInt(st.nextToken());
	   int[][] arr = new int[size+1][size+1];
	   int[][] sum = new int[size+1][size+1];
	   for(int i=1; i<arr.length; i++) {
		   st = new StringTokenizer(br.readLine());
		   while(st.hasMoreTokens()) {
			   for(int j=1; j<arr.length;j++) {
				   arr[i][j] =  Integer.parseInt(st.nextToken());
				   sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
				 //  System.out.print(sum[i][j]);
			   }
		   }
		  // System.out.println();
	   }
	   
	   for(int i=0; i<repeat;i++) {
		   st = new StringTokenizer(br.readLine());
		   //2
		   int x1 = Integer.parseInt(st.nextToken());
		   //2
		   int y1 = Integer.parseInt(st.nextToken());
		   //3
		   int x2 = Integer.parseInt(st.nextToken());
		   //4
		   int y2 = Integer.parseInt(st.nextToken());
		   
		   int b = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
		   System.out.println(b);
	   }
	   
	   
	}
		
		
		
	}
