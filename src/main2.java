import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class main2 {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		Map<Integer, String> m = new TreeMap<Integer, String>();
		String[] v = new String[4];
		v[0] = "";
		v[1] = "";
		v[2] = "";
		v[3] = "";
		while (lee.hasNext()) {
			String l = lee.nextLine();
			int id = 0;
			if (v[0].length() == 0)
				v[0] = convIP(l.substring(0, 32));
			int aux = convBinToInt(l.substring(32 + 8, 32 + 16));
			
			//if (aux != (l.length() / 8)) l = l.substring(0, aux * 8);
			
			if (v[1].length() == 0)
				v[1] = aux + "";
			else if (aux > Integer.parseInt(v[1]))
				v[1] = aux + "";
			if (v[3].length() == 0)
				v[3] = convIP(l.substring(l.length() - 32, l.length()));
			
			boolean sw = true;
			String g = convMsg(l.substring(32 + 16, l.length() - 32));
			for (Map.Entry<Integer, String> ms : m.entrySet()) {
				if (ms.getValue().compareTo(g)==0) sw=false;
			}
			if(sw)
				m.put(convBinToInt(l.substring(32, 32 + 8)), g);
		}
		for (Map.Entry<Integer, String> ms : m.entrySet()) {
			if (v[2].length() == 0)
				v[2] = ms.getValue();
			else
				v[2] = v[2] + ms.getValue();
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(v[i]);
		}
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