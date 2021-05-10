import java.util.*;

public class ServicoDePagamentos {

	private final Map<String, Double> pagamentos = new HashMap<>();

	public String pagar(ReservaInput reservaInput, double preco) {
		String id = UUID.randomUUID().toString();
		pagamentos.put(id, preco);
		return id;
	}

}
