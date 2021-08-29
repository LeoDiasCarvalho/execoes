/**
 * 
 */
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author leo_dias
 *
 */
public class Reserva {
	
	private int numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva() {
	}

	public Reserva(int numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); 
	}

	public String atualizacao(Date entrada, Date saida) {
		Date agora = new Date();
		if(entrada.before(agora) || saida.before(agora)) {
			return "data de atualização devem ser futuras!";
		}else if(!saida.after(entrada)) {
			return "data de saida tem que ser posterior a de entrada!";
		}else {
			this.entrada = entrada;
			this.saida = saida;
			return null;
		}
	}
	
	public String toString() {
		return "Quarto: " + numeroQuarto
				+ ", entrada: " + sdf.format(entrada)
				+ ", saída: " + sdf.format(saida)
				+ ", Duração: " + duracao()
				+ " noites.";
	}
	
}
