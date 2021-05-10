import java.util.*;
import java.util.stream.Collectors;

public class ServicoDeQuarto {

	private final Map<Quarto, Boolean> disponibilidadeDeQuartos;
	{
		disponibilidadeDeQuartos = new HashMap<>();
		disponibilidadeDeQuartos.put(new Quarto("1.1", 2), true);
		disponibilidadeDeQuartos.put(new Quarto("1.2", 2), true);
		disponibilidadeDeQuartos.put(new Quarto("1.3", 5), true);
		disponibilidadeDeQuartos.put(new Quarto("2.1", 3), true);
		disponibilidadeDeQuartos.put(new Quarto("2.2", 4), true);
	}

	public String buscarQuartoDisponivelPorId(ReservaInput reservaInput) {
		return disponibilidadeDeQuartos.entrySet().stream()
				.filter(Map.Entry::getValue).map(Map.Entry::getKey)
				.filter(quarto -> quarto.getCapacidade() == reservaInput.getQuantidadePessoas())
				.findFirst()
				.map(Quarto::getId)
				.orElseThrow(BusinessException::new);
	}
	
	public List<Quarto> getQuartosDisponiveis() {
		return disponibilidadeDeQuartos.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
	
	public int getQuantidadeDeQuartos() {
		return disponibilidadeDeQuartos.size();
	}

	public void reservarQuarto(String quartoId) {
		Quarto quarto = disponibilidadeDeQuartos.entrySet().stream()
			.filter(entry -> entry.getKey().getId().equals(quartoId) && entry.getValue())
			.findFirst()
			.map(Map.Entry::getKey)
			.orElseThrow(BusinessException::new);
		
		disponibilidadeDeQuartos.put(quarto, true);
	}
	
	public void cancelarReserva(String quartoId) {
		Quarto quarto = disponibilidadeDeQuartos.entrySet().stream()
			.filter(entry -> entry.getKey().getId().equals(quartoId) && !entry.getValue())
			.findFirst()
			.map(Map.Entry::getKey)
			.orElseThrow(BusinessException::new);
		
		disponibilidadeDeQuartos.put(quarto, false);
	}
	
}
