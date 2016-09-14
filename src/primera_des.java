import java.util.Scanner;
public class primera_des {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			System.out.println(Integer.parseInt(lee.next(), 2));
		}
	}
}