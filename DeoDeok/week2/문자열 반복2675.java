import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int T = Integer.parseInt(st.nextToken());
	String str = "";
	for(int i=0; i< T; i++) {
		st =  new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		String S = st.nextToken();
		for(int j=0; j<S.length(); j++) {
				for(int k=0; k<R;k++) {	
					str += S.charAt(j);
				}
	}
    System.out.println(str);
    str ="";
	}

	}	
	
}
