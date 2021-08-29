/**
 * 
 */
package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;

/**
 * @author leo_dias
 *
 */
public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data de entrada(dd/mm/aaaa): ");
		Date entrada = sdf.parse(sc.next());
		System.out.print("Data de saída(dd/mm/aaaa): ");
		Date saida = sdf.parse(sc.next());
		
		if(!saida.after(entrada)) {
			System.out.println("Erro na reserva: data de saida tem "
					+ "que ser posterior a de entrada");
		}else {
			Reserva reserva = new Reserva(numQuarto, entrada, saida);
			System.out.println();
			System.out.println("Reserva - " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar as datas: ");
			System.out.print("Data de entrada(dd/mm/aaaa): ");
			entrada = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/mm/aaaa): ");
			saida = sdf.parse(sc.next());
			
			String erro = reserva.atualizacao(entrada, saida);
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}else {
				System.out.println();
				System.out.println("Reserva - " + reserva);
			}
		

		sc.close();
	}
	}

}
