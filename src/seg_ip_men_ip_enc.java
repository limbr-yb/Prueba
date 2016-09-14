import java.util.Scanner;
public class seg_ip_men_ip_enc {

	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			String ip_origen = lee.nextLine();
			String mensaje = lee.nextLine();
			String ip_destno = lee.nextLine();
			System.out.println(conv_ip(ip_origen) + conv_msg(mensaje) + conv_ip(ip_destno));
		}
	}

	public static String conv_msg(String x){
		String out = "";
		for (int i=0; i<x.length(); i++) {
			out = out + (convIntToBin((int)x.charAt(i)));
		}
		return out;
	}

	public static String conv_ip(String x){
		String out = "";
		String l = "";
		for (int i=0; i<x.length(); i++) {
			char a = x.charAt(i);
			if(a != '.') l = l + a;
			else {
				out = out + convIntToBin(Integer.parseInt(l));
				l = "";
			}
		}
		out = out + convIntToBin(Integer.parseInt(l));
		return out;
	}

	public static String convIntToBin(int x){
		return String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0');
	}
}