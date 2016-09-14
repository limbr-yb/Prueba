import java.util.Scanner;
public class  primera_enc {

	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			int c = lee.nextInt();
			String l = "";
			while(c>0){
				l = (c%2) + l;
				c = c/2;
			}
			System.out.println(l);
		}
	}
}
