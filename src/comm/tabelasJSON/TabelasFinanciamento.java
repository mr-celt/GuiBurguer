package comm.tabelasJSON;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import comm.tabelas.TabelaPrice;

@WebServlet("/TabelasFinanciamento")
public class TabelasFinanciamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TabelasFinanciamento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = new PrintWriter(response.getOutputStream());

		out.write("Hola que tal");

		String vp = request.getParameter("valorprincipal");
		String tj = request.getParameter("vaxadejuros");
		String pc = request.getParameter("parcelas");
		String mainJson = request.getParameter("json");

		double vlpr = Double.parseDouble(vp);
		double txjr = Double.parseDouble(tj);
		int parc = Integer.parseInt(pc);

		TabelaPrice simulador = new TabelaPrice();
		simulador.setPrincipal(vlpr);
		simulador.setTaxaJuros(txjr);
		simulador.setParcelas(parc);

		JSONObject sacJSON = new JSONObject();
		JSONObject priceJSON = new JSONObject();

		try {

			sacJSON.put("Principal", vlpr);
			sacJSON.put("Taxa de juros", txjr);
			sacJSON.put("Quantidade parcelas", parc);
			sacJSON.put("Parcelas", simulador.tabelaSac1JSON());

		} catch (JSONException e) {
			throw new ServletException(e);
		}

		try {
			priceJSON.put("Principal", vlpr);
			priceJSON.put("Taxa de juros", txjr);
			priceJSON.put("Quantidade de parcelas", parc);
			priceJSON.put("Parcelas", simulador.tabelaPrice1JSON());
		} catch (JSONException e) {
			throw new ServletException(e);
		}

		if (mainJson != null) {
			out.write(sacJSON.toString());
		} else {
			out.write(priceJSON.toString());
		}

		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
