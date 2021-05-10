import java.time.temporal.ChronoUnit;

public class ServicoDeReserva {

	private final ServicoDePagamentos servicoDePagamentos;
	private final ServicoDeQuarto servicoDeQuarto;
	private final ReservaDAO reservaDAO;
	private final EnviadorDeEmail enviadorDeEmail;

	private final static double PRECO_BASE_REAIS = 50.0;

	public int getQuantidadeDisponivel() {
		return servicoDeQuarto.getQuartosDisponiveis()
				.stream()
				.map(Quarto::getCapacidade)
				.reduce(0, Integer::sum);
	}
	
	public double calcularValor(ReservaInput reservaInput) {
		long qtdNoites = ChronoUnit.DAYS.between(reservaInput.getDataInicio(), reservaInput.getDataFinal());
		return PRECO_BASE_REAIS * reservaInput.getQuantidadePessoas() * qtdNoites;
	}

	public String efetuarReserva(ReservaInput reservaInput) {
		String roomId = servicoDeQuarto.buscarQuartoDisponivelPorId(reservaInput);
		double price = calcularValor(reservaInput);

		if (reservaInput.isPagamentoAdiantado()) {
			servicoDePagamentos.pagar(reservaInput, price);
		}

		reservaInput.setIdQuarto(roomId);
		String bookingId = reservaDAO.salvar(reservaInput);
		servicoDeQuarto.reservarQuarto(roomId);
		enviadorDeEmail.enviarConfirmacaoReserva(bookingId);
		return bookingId;
	}
	
	public void cancelarReserva(String id) {
		ReservaInput request = reservaDAO.buscar(id);
		servicoDeQuarto.cancelarReserva(request.getIdQuarto());
		reservaDAO.excluir(id);
	}

	public ServicoDeReserva(ServicoDePagamentos servicoDePagamentos, ServicoDeQuarto servicoDeQuarto, ReservaDAO reservaDAO,
							EnviadorDeEmail enviadorDeEmail) {
		super();
		this.servicoDePagamentos = servicoDePagamentos;
		this.servicoDeQuarto = servicoDeQuarto;
		this.reservaDAO = reservaDAO;
		this.enviadorDeEmail = enviadorDeEmail;
	}

}
