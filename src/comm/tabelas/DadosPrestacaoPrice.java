package tabelas;

import java.text.DecimalFormat;

public class DadosPrestacaoPrice {
	private double vlPrestacao;
	private double vlAmortizado;
	private double vlJuros;
	
	
	
	
	public double getVlPrestacao() {
		return vlPrestacao;
	}
	public void setVlPrestacao(double vlPrestacao) {
		this.vlPrestacao = vlPrestacao;
	}
	public double getVlAmortizado() {
		return vlAmortizado;
	}
	public void setVlAmortizado(double vlAmortizado) {
		this.vlAmortizado = vlAmortizado;
	}
	public double getVlJuros() {
		return vlJuros;
	}
	public void setVlJuros(double vlJuros) {
		this.vlJuros = vlJuros;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###,#00.00");
		return String.format("Prestação %s. Valor amortizado = %s. Valor dos juros = %s", df.format(getVlPrestacao()) , df.format(getVlAmortizado()), df.format(getVlJuros()) );
	}
}