import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServicoDeQuartoTest {

    ServicoDeReserva servicoDeReserva;
    ServicoDeQuarto servicoDeQuarto;

    @BeforeEach
    public void setup(){
        servicoDeQuarto = mock(ServicoDeQuarto.class);
        servicoDeReserva = new ServicoDeReserva(mock(ServicoDePagamentos.class),
                servicoDeQuarto, mock(ReservaDAO.class), mock(EnviadorDeEmail.class));
        List<Quarto> quartos = new ArrayList<>();
        quartos.add(new Quarto("114", 2));
        when(servicoDeQuarto.getQuartosDisponiveis()).thenReturn(quartos);
    }

    @Test
    void Deve_Retornar_Somente_Um_Quarto_Com_Capacidade_Para_Duas_Pessoas(){
        int actual = servicoDeReserva.getQuantidadeDisponivel();

        int expected = 2;

        assertEquals(expected, actual);
    }

}