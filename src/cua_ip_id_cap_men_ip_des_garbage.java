import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class cua_ip_id_cap_men_ip_des_garbage {

	//El programa imprime linea a linea las cadenas Binarias
	// "IP_Origen - ID - Tamaño_Paquete - Mensaje - IP_Destino"

	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);

		Map<Integer, String> m = new TreeMap<Integer, String>();
		String[] v = new String[4];
		v[0] = "";
		v[1] = "";
		v[2] = "";
		v[3] = "";
		while(lee.hasNext()){
			String l = lee.nextLine();
			int id = 0;
			
			//obtener ip_o - convIP( l.substring(0,32) );
			//obtener id   - convBinToInt( l.substring(32,32+8) );
			//obtener cap  - convBinToInt( l.substring(32+8, 32+16) );
			//obtener msg  - convMsg( l.substring(32+16, l.length()-32) );
			//obtener ip_d - convIP( l.substring(l.length()-32, l.length()) );

			System.out.print(convIP( l.substring(0,32) ));
			System.out.print(" - ");
			System.out.print(convBinToInt( l.substring(32,32+8) ));
			System.out.print(" - ");
			int p = convBinToInt( l.substring(32+8, 32+16) );
			if ((p*8) != l.length()) l = l.substring(0, p*8);
			System.out.print(p);
			System.out.print(" - ");
			System.out.print(convMsg( l.substring(32+16, l.length()-32) ));
			System.out.print(" - ");
			System.out.print(convIP( l.substring(l.length()-32, l.length()) ));
			System.out.println("");

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