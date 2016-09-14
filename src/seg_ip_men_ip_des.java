import java.util.Scanner;
public class seg_ip_men_ip_des {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			String l = lee.nextLine();

			System.out.println(convIP( l.substring(0,32) ));
			System.out.println(convMsg( l.substring(32, l.length()-32) ));
			System.out.println(convIP( l.substring(l.length()-32, l.length()) ));
		}
	}

	public static String convMsg(String x){
		String out = "";
		int t = x.length()/8;
		for (int i=0; i<t; i++) {
			out = out + (char)(convBinToInt(x.substring(8*i, (8*i)+8)));
		}
		return out;
	}

	public static String convIP(String x){
		String out ="";
		for (int i=0; i<4; i++) {
			out = out + (convBinToInt(x.substring(i*8, (i*8)+8)));
			if(i != 3) out = out + ".";
		}
		return out;
	}

	public static int convBinToInt(String x){
		return Integer.parseInt(x, 2);
	}
}