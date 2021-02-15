package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Resersa;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(" Número Reserva: ");
		int numero = sc.nextInt();
		System.out.println("Digite a data Da entrada (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Digite a data Da saída (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro reserva da anteriro a data do chekin");
		}else{
			Resersa reserva = new Resersa(numero, checkIn, checkOut);
			System.out.println("Reserva" +reserva);
			System.out.println();
			System.out.println("Alteração da reserva: ");
		
			System.out.println("Digite a data Da entrada (dd/MM/yyyy): ");
			 checkIn = sdf.parse(sc.next());
			System.out.println("Digite a data Da saída (dd/MM/yyyy): ");
			 checkOut = sdf.parse(sc.next());
			 
			 Date agora = new Date ();
			 if (checkIn.before(agora)|| checkOut.before(agora)) {
				System.out.println("Erro na reserva, as datas não podem ser anteriores");
			 }else  if(!checkOut.after(checkIn)) {
					System.out.println("Erro reserva da anteriro a data do chekin");
					}else{
						reserva.alterarDatas(checkIn, checkOut);
						System.out.println("Reserva" +reserva);
		}
		
		
		}
		
		
		
		
		
		sc.close();
	}

}
