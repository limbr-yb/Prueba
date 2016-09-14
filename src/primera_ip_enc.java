import java.util.Scanner;
public class primera_ip_enc {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			String l = lee.next();
			String ax = "";
			for (int i=0; i<l.length(); i++) {
				char f = l.charAt(i);
				if(f != '.') ax = ax + f;
				else {
					System.out.print(conv(Integer.parseInt(ax)));
					ax = "";
				}
			}
			System.out.print(conv(Integer.parseInt(ax)));
			System.out.println();
		}
	}

	public static String conv(int x){
		return String.format("%8s" ,Integer.toBinaryString(x)).replace(' ', '0');
	}
}