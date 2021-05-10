public class ConversorDeMoedas {

	private static final double TAXA_CAMBIO = 0.18;
	
	public static double paraReal(double dolar) {
		return dolar * TAXA_CAMBIO;
	}
	
}
