package tabelas;

import java.text.DecimalFormat;

public class DadosTabelaSac {
	private double vlPrincipal;
	private double vlJuros;
	private double vlParcelas;
	
	
	public double getVlPrincipal() {
		return vlPrincipal;
	}
	
	public void setVlPrincipal(double vlPrincipal) {
		this.vlPrincipal = vlPrincipal;
	}
	
	public double getVlJuros() {
		return vlJuros;
	}
	
	public void setVlJuros(double vlJuros) {
		this.vlJuros = vlJuros;
	}
	
	public double getVlParcelas() {
		return vlParcelas;
	}
	
	public void setVlParcelas(double vlParcelas) {
		this.vlParcelas = vlParcelas;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("###,###,#00.00");
		return String.format("Prestação %s. Valor amortizado = %s. Valor dos juros = %s", df.format(getVlPrincipal()) , df.format(getVlParcelas()), df.format(getVlJuros()) );
	}
}
