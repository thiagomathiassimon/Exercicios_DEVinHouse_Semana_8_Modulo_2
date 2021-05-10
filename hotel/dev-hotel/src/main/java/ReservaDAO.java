import java.util.*;

public class ReservaDAO {

	private final Map<String, ReservaInput> reservas = new HashMap<>();

	public String salvar(ReservaInput reservaInput) {
		String id = UUID.randomUUID().toString();
		reservas.put(id, reservaInput);
		return id;
	}
	
	public ReservaInput buscar(String id) {
		return reservas.get(id);
	}
	
	public void excluir(String reservaId) {
		reservas.remove(reservaId);
	}

}
