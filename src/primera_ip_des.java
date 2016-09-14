import java.util.Scanner;
public class primera_ip_des {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			String l = lee.next();
			for (int i=0; i<4; i++) {
				System.out.print(conv(l.substring(i*8, (i*8)+8)));
				if(i != 3) System.out.print(".");
			}
			System.out.println();
		}
	}

	public static int conv(String x){
		return Integer.parseInt(x, 2);
	}
}