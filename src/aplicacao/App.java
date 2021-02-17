package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Resersa;
import model.excecoes.DominioExcecoes;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println(" Número Reserva: ");
			int numero = sc.nextInt();
			System.out.println("Digite a data Da entrada (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Digite a data Da saída (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			System.out.println("Erro reserva da anteriro a data do chekin");
	
			Resersa reserva = new Resersa(numero, checkIn, checkOut);
			System.out.println("Reserva" +reserva);
			System.out.println();
			System.out.println("Alteração da reserva: ");
		
			System.out.println("Digite a data Da entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Digite a data Da saída (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			 
			
			reserva.alterarDatas(checkIn, checkOut);
			System.out.println("Reserva: " +reserva);
		}
		catch (ParseException e) {
			System.out.println("formato da Data Invalida!");
		}
		catch (DominioExcecoes e) {
			System.out.println("Erro em reserva: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	
	
	
		
		
		
		sc.close();
	}

}
