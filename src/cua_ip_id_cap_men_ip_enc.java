import java.util.Scanner;
public class cua_ip_id_cap_men_ip_enc {
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		while(lee.hasNext()){
			String ip_origen = lee.nextLine();
			String id = lee.nextLine();
			String capacidad = lee.nextLine();
			String mensaje = lee.nextLine();
			String ip_destino = lee.nextLine();

			int capacidad_int = Integer.parseInt(capacidad);
			int id_int = Integer.parseInt(id);
			if(capacidad_int > 10){
				if((id_int+(mensaje.length()/(capacidad_int-10))) <= 255){
					String ip_origen_bin = convIP(ip_origen);
					String ip_destino_bin = convIP(ip_destino);
					
					String l = "";
					for (int i=0; i<mensaje.length(); i++) {
						if(l.length() < capacidad_int-10){
							l = l + mensaje.charAt(i);
						} else {
							System.out.print(ip_origen_bin);
							System.out.print(convIntToBin(id_int));
							System.out.print(convIntToBin(capacidad_int));
							System.out.print(convMsg(l));
							System.out.print(ip_destino_bin);
							System.out.println();
							l = "";
							l = l + mensaje.charAt(i);
							id_int++;
						}
					}
					if(l.length()>0){
						System.out.print(ip_origen_bin);
						System.out.print(convIntToBin(id_int));
						System.out.print(convIntToBin(10+l.length()));
						System.out.print(convMsg(l));
						System.out.print(ip_destino_bin);
						System.out.println();
					}
				}
				else System.out.println("Error en el id.!");
			}
			else System.out.println("Error en el tamanio del paquete.!");
		}
	}

	public static String convMsg(String x){
		String out = "";
		for (int i=0; i<x.length(); i++) {
			out = out + convIntToBin( (int)x.charAt(i) );
		}
		return out;
	}

	public static String convIP(String x){
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