/**
 * 
 */
package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.execoes.ExecoesDeDominio;

/**
 * @author leo_dias
 *
 */
public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Número do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data de entrada(dd/mm/aaaa): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data de saída(dd/mm/aaaa): ");
		Date saida = sdf.parse(sc.next());
		
			Reserva reserva = new Reserva(numQuarto, entrada, saida);
			System.out.println();
			System.out.println("Reserva - " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar as datas: ");
			System.out.print("Data de entrada(dd/mm/aaaa): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/mm/aaaa): ");
			saida = sdf.parse(sc.next());
			
			reserva.atualizacao(entrada, saida);
			System.out.println();
			System.out.println("Reserva - " + reserva);
		
		}
		catch(ParseException e) {
			System.out.println("Formato da data inválido!");
		}
		catch(ExecoesDeDominio e) {
			System.out.println("Erro na reserva - " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}
}


