package tabelas;

import java.util.Calendar;

public class Prestacoes {
	private float principal;

	public float getPrincipal() {
		return principal;
	}

	public void setPrincipal(float principal) {
		this.principal = principal;
	}

	public void exibeParcelas(int parcelas, int intervaloDePgto) {
		// Método que deve pegar o total de parcelas e exibir o calendario pagamento
		// destas, baseadas no intervalo de pagamento.
		exibeParcelas(parcelas, intervaloDePgto, false);
		
		
		
		
//		Calendar hora0 = Calendar.getInstance();
//		for (int i = 0; i < parcelas; i++) {
//			System.out.println("Dia: " + hora0.get(Calendar.DAY_OF_MONTH));
//			System.out.println("Mes: " + (hora0.get(Calendar.MONTH) + 1));
//			System.out.println("Ano: " + hora0.get(Calendar.YEAR));
//			System.out.println("- - - - - - - - - - - - - - - - - - - ");
//
//			hora0.add(Calendar.DAY_OF_MONTH, intervaloDePgto);
//		}
	}

	public void exibeParcelas(int parcelas, int intervaloDePgto, boolean diautil) {
		// Método com função similar ao exibeParcelas, porém ele não permite o pagamento
		// em fins de semana, passando para a proxima segunda.
		Calendar hora0 = Calendar.getInstance();
		for (int i = 0; i < parcelas; i++) {
			System.out.println("Dia: " + hora0.get(Calendar.DAY_OF_MONTH));
			System.out.println("Mes: " + (hora0.get(Calendar.MONTH) + 1));
			System.out.println("Ano: " + hora0.get(Calendar.YEAR));
			System.out.println("- - - - - - - - - - - - - - - - - - - ");

			hora0.add(Calendar.DAY_OF_MONTH, intervaloDePgto);

			if (diautil == true) {
				if (hora0.get(Calendar.DAY_OF_WEEK) == 1) {
					hora0.add(Calendar.DAY_OF_MONTH, 1);
				} else if (hora0.get(Calendar.DAY_OF_WEEK) == 7) {
					hora0.add(Calendar.DAY_OF_MONTH, 2);
				}
			}
		}
	}

	// A partir daqui test zone

	public static void main(String[] args) {
		Prestacoes t1 = new Prestacoes();

		System.out.println(t1.getPrincipal());

		t1.exibeParcelas(8, 25);
		t1.exibeParcelas(8, 25, true);
	}

}
