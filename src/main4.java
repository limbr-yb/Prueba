import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class main4 {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		Map<Integer, String> m = new TreeMap<Integer, String>();
		String mensaje="";
		String aux2 = "";
		while (lee.hasNext()) {
			String l = lee.nextLine();
			boolean sw = true;
			
			int p = convBinToInt( l.substring(32+8, 32+16) );
			if (p <= 10) continue;
			if ((p*8) != l.length()) l = l.substring(0, 8*6)+ l.substring(8*6, (8*6)+(p-10) ) + l.substring(l.length()-32, l.length());
			
			String g = convMsg(l.substring(32 + 16, l.length() - 32));
			for (Map.Entry<Integer, String> ms : m.entrySet()) {
				if (ms.getValue().compareTo(g)==0){
					if(ms.getValue() != "")
					aux2=aux2+ms.getValue()+"\n";
					sw=false;
				}
			}
			if(sw)
				m.put(convBinToInt(l.substring(32, 32 + 8)), g);
		}
		for (Map.Entry<Integer, String> ms : m.entrySet()) {
			if (mensaje.length() == 0)
				mensaje = ms.getValue();
			else
				mensaje = mensaje + ms.getValue();
		}
		
		System.out.println(mensaje);
		System.out.println();
		System.out.println("Se repitieron: \n" + aux2);
	}

	public static String convMsg(String x) {
		String out = "";
		int t = x.length() / 8;
		for (int i = 0; i < t; i++) {
			out = out + (char) (convBinToInt(x.substring(8 * i, (8 * i) + 8)));
		}
		return out;
	}

	public static String convIP(String x) {
		String out = "";
		for (int i = 0; i < 4; i++) {
			out = out + (convBinToInt(x.substring(i * 8, (i * 8) + 8)));
			if (i != 3)
				out = out + ".";
		}
		return out;
	}

	public static int convBinToInt(String x) {
		return Integer.parseInt(x, 2);
	}
}