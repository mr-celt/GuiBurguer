package comm.tabelas;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class TabelaPrice {
	private double principal;
	private double taxaJuros;
	private int parcelas;
	private DecimalFormat df;

	public TabelaPrice() {
		df = new DecimalFormat("###,###,#00.00");
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public double getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public double tabelaPrice(double principal, double taxaJuros, double parcelas) {
		double pmt;
		double divisor;
		pmt = Math.pow((1 + taxaJuros / 100), parcelas);
		pmt = pmt * taxaJuros / 100;
		divisor = Math.pow((1 + taxaJuros / 100), parcelas);
		divisor = divisor - 1;
		pmt = pmt / divisor;
		pmt = principal * pmt;

		return pmt;
	}

	public double[] tabelaPrice1(double principal, double taxaJuros, int parcelas) {
		double[] result = new double[parcelas];
		double pmt = tabelaPrice(principal, taxaJuros, parcelas);
		for (int i = 0; i < parcelas; i++) {
			result[i] = pmt;
		}

		return result;
	}

	public JSONArray tabelaPrice1JSON() throws JSONException {

		double tbj[] = tabelaPrice1(principal, taxaJuros, parcelas);

		JSONArray jArr = new JSONArray();
		for (double v : tbj) {
			jArr.put(v);
		}

		return jArr;
	}

	public DadosPrestacaoPrice[] tabelaPriceDetalhada(double principal, double taxaJuros, int parcelas) {

		DadosPrestacaoPrice[] result = new DadosPrestacaoPrice[parcelas];
		double pmt = tabelaPrice(principal, taxaJuros, parcelas);

		double tx = 1.0 / parcelas;
		double mlt = tx;

		for (int i = 0; i < parcelas; i++) {
			DadosPrestacaoPrice dpp = new DadosPrestacaoPrice();
			dpp.setVlPrestacao(pmt);
			dpp.setVlAmortizado(pmt * mlt);
			dpp.setVlJuros(pmt - dpp.getVlAmortizado());
			mlt += tx;

			result[i] = dpp;
		}

		return result;
	}

	public ArrayList<DadosPrestacaoPrice> tabelaPriceDetalhada1(double principal, double taxaJuros, int parcelas) {

		ArrayList<DadosPrestacaoPrice> result = new ArrayList<DadosPrestacaoPrice>();

		double pmt = tabelaPrice(principal, taxaJuros, parcelas);

		double tx = 1.0 / parcelas;
		double mlt = tx;

		for (int i = 0; i < parcelas; i++) {
			DadosPrestacaoPrice dpp = new DadosPrestacaoPrice();
			dpp.setVlPrestacao(pmt);
			dpp.setVlAmortizado(pmt * mlt);
			dpp.setVlJuros(pmt - dpp.getVlAmortizado());
			mlt += tx;

			result.add(dpp);
		}

		return result;
	}

	public void tabelaSac(double principal, double taxaJuros, double parcelas) {

		double amortizacao = principal / parcelas;
		for (int i = 0; i < parcelas; i++) {
			double juros = (taxaJuros / 100) * principal;
			double valorParcela = amortizacao + juros;
			principal = principal - amortizacao;
			System.out.println(String.format("parcela nº %d: %s", i + 1, df.format(valorParcela)));

		}
	}

	public double[] tabelaSac1(double principal, double taxaJuros, int parcelas) {

		double[] result = new double[parcelas];
		double amortizacao = principal / parcelas;

		for (int i = 0; i < parcelas; i++) {
			double juros = (taxaJuros / 100) * principal;
			double valorParcela = amortizacao + juros;
			principal = principal - amortizacao;
			result[i] = valorParcela;
		}

		return result;
	}

	public JSONArray tabelaSac1JSON() throws JSONException {

		double tbj[] = tabelaSac1(principal, taxaJuros, parcelas);

		JSONArray jArr = new JSONArray();
		for (double v : tbj) {
			jArr.put(v);
		}

		return jArr;
	}

	public DadosTabelaSac[] tabelaSacDetalhada(double principal, double taxaJuros, int parcelas) {
		DadosTabelaSac[] result = new DadosTabelaSac[parcelas];

		double pmt[] = tabelaSac1(principal, taxaJuros, parcelas);
		double tx = (taxaJuros / 100) * principal;
		double amort = principal / parcelas;

		for (int i = 0; i < parcelas; i++) {
			DadosTabelaSac dts = new DadosTabelaSac();
			dts.setVlPrincipal(pmt[i]);
			dts.setVlParcelas(amort);
			dts.setVlJuros(tx);

			result[i] = dts;
		}
		return result;
	}

	public ArrayList<DadosTabelaSac> tabelaSacDetalhada1(double principal, double taxaJuros, int parcelas) {
		ArrayList<DadosTabelaSac> result = new ArrayList<DadosTabelaSac>();

		double pmt[] = tabelaSac1(principal, taxaJuros, parcelas);
		double tx = (taxaJuros / 100) * principal;
		double amort = principal / parcelas;

		for (int i = 0; i < parcelas; i++) {
			DadosTabelaSac dts = new DadosTabelaSac();

			dts.setVlPrincipal(pmt[i]);
			dts.setVlParcelas(amort);
			dts.setVlJuros(tx);

			result.add(dts);
		}
		return result;
	}

	public void tabelaSacre(double principal, double taxaJuros, int parcelas) {

		double amortizacao = principal / parcelas;
		double juros = (taxaJuros / 100) * principal;
		double valorParcela = amortizacao + juros;

		int periodo = parcelas / 3;

		System.out.println(valorParcela);
	}

}