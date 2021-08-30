/**
 * 
 */
package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.execoes.ExecoesDeDominio;

/**
 * @author leo_dias
 *
 */
public class Reserva {
	
	private int numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Date agora = new Date();
	
	
	public Reserva() {
	}

	public Reserva(int numeroQuarto, Date entrada, Date saida) throws ExecoesDeDominio {
		if(entrada.before(agora) || saida.before(agora)) {
			throw new ExecoesDeDominio("data da reserva deve ser futura!");
		}else if(saida.after(entrada)){
			throw new ExecoesDeDominio("data de saida deve ser posterior a de entrada!");
		}else {
			this.numeroQuarto = numeroQuarto;
			this.entrada = entrada;
			this.saida = saida;
		}
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

	public void atualizacao(Date entrada, Date saida) throws ExecoesDeDominio {
		Date agora = new Date();
		if(entrada.before(agora) || saida.before(agora)) {
			throw new ExecoesDeDominio("data de atualização devem ser futuras!");
		}else if(!saida.after(entrada)) {
			throw new ExecoesDeDominio("data de saída tem que ser posterior a de entrada!");
		}else {
			this.entrada = entrada;
			this.saida = saida;
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
