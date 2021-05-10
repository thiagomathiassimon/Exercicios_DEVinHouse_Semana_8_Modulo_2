import java.time.LocalDate;

public class ReservaInput {

	private final String idUsuario;
	private final LocalDate dataInicio;
	private final LocalDate dataFinal;
	private final int quantidadePessoas;
	private final boolean pagamentoAdiantado;
	private String idQuarto;
	
	public ReservaInput(String idUsuario, LocalDate dataInicio, LocalDate dataFinal,
						int quantidadePessoas, boolean pagamentoAdiantado) {
		super();
		this.idUsuario = idUsuario;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.quantidadePessoas = quantidadePessoas;
		this.pagamentoAdiantado = pagamentoAdiantado;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public boolean isPagamentoAdiantado() {
		return pagamentoAdiantado;
	}

	public String getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(String idQuarto) {
		this.idQuarto = idQuarto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result + quantidadePessoas;
		result = prime * result + (pagamentoAdiantado ? 1231 : 1237);
		result = prime * result + ((idQuarto == null) ? 0 : idQuarto.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaInput other = (ReservaInput) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (quantidadePessoas != other.quantidadePessoas)
			return false;
		if (pagamentoAdiantado != other.pagamentoAdiantado)
			return false;
		if (idQuarto == null) {
			if (other.idQuarto != null)
				return false;
		} else if (!idQuarto.equals(other.idQuarto))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
}
