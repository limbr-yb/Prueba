import java.util.Scanner;
public class ter_ip_cap_men_ip_des {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		String[] v = new String[4];
		v[0] = "";
		v[1] = "";
		v[2] = "";
		v[3] = "";

		while(lee.hasNext()){
			String l = lee.nextLine();

			if(v[0].length() == 0) v[0] = convIP( l.substring(0,32) );
			if(v[1].length() == 0) v[1] = convBinToInt( l.substring(32,32+8) ) + "";
			else if(convBinToInt( l.substring(32,32+8) ) > Integer.parseInt(v[1])) v[1] = convBinToInt( l.substring(32,32+8) ) + "";
			if(v[2].length() == 0) v[2] = convMsg( l.substring(32+8, l.length()-32) );
			else v[2] = v[2] + convMsg( l.substring(32+8, l.length()-32) );
			if(v[3].length() == 0) v[3] = convIP( l.substring(l.length()-32, l.length()) );
		}
		for (int i=0; i<4; i++) {
			System.out.println(v[i]);
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