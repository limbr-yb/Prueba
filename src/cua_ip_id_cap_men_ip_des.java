import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class cua_ip_id_cap_men_ip_des {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);

		Map<Integer, String> m = new TreeMap<Integer, String>();
		String[] v = new String[4];
		v[0] = "";	// IP Origen
		v[1] = "";	// Tamaño del paquete
		v[2] = "";	// mensaje
		v[3] = "";	// IP Destino
		while(lee.hasNext()){
			String l = lee.nextLine();
			int id = 0;
			
			//obtener ip_o - convIP( l.substring(0,32) );
			//obtener id   - convBinToInt( l.substring(32,32+8) );
			//obtener tam  - convBinToInt( l.substring(32+8, 32+16) );
			//obtener msg  - convMsg( l.substring(32+16, l.length()-32) );
			//obtener ip_d - convIP( l.substring(l.length()-32, l.length()) );

			//se guarda el IP Origen
			if(v[0].length() == 0) v[0] = convIP( l.substring(0,32) );
			
			//Tamaño del paquete
			int aux = convBinToInt( l.substring(32+8,32+16) );
			//Verifica y hace cumpler el tamaño del paquete
			if(aux != (l.length()/8) ) l = l.substring(0, aux*8);

			//se guarda el Tamaño del paquete (se busca el tamaño mas grande)
			if(v[1].length() == 0) v[1] = aux + "";
			else if(aux > Integer.parseInt(v[1])) v[1] = aux + "";

			//se guarda el IP Destino
			if(v[3].length() == 0) v[3] = convIP( l.substring(l.length()-32, l.length()) );

			//se almacena en un mapa las cadenas, junto con su llave <ID, mensaje_parcial>
			m.put( convBinToInt( l.substring(32,32+8) ) , convMsg( l.substring(32+16, l.length()-32) ) );

		}

		//Se recorre el mapa binario y se concatena los valores en v[2] (Mensaje_total)
		for (Map.Entry<Integer, String> ms : m.entrySet()) {
			if(v[2].length() == 0) v[2] = ms.getValue();
			else v[2] = v[2] + ms.getValue();
		}

		//Se imprime el vector con toda la informacion requerida
		for (int i=0; i<4; i++) {
			System.out.println(v[i]);
		}
	}

	//Convierte una cadena Binaria a su equivalente en ASCII y luego a un String
	public static String convMsg(String x){
		String out = "";
		int t = x.length()/8;  //cantidad de caracteres en la cadena
		for (int i=0; i<t; i++) {
			out = out + (char)(convBinToInt(x.substring(8*i, (8*i)+8)));
		}
		return out;
	}

	//convierte una cadena Binaria a un numero IP
	public static String convIP(String x){
		String out ="";
		for (int i=0; i<4; i++) {
			out = out + (convBinToInt(x.substring(i*8, (i*8)+8)));
			if(i != 3) out = out + ".";
		}
		return out;
	}

	//Convierte un String Binario a su equivalente numerico (Integer)
	public static int convBinToInt(String x){
		return Integer.parseInt(x, 2);
	}
}