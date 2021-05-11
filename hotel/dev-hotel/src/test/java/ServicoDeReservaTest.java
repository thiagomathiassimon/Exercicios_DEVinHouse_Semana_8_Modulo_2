import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

class ServicoDeReservaTest {

    ServicoDeReserva servicoDeReserva;

    @BeforeEach
    public void setup(){
        servicoDeReserva = mock(ServicoDeReserva.class);
    }

    @Test
    void Deve_Testar_Se_O_Metodo_geQuantidadeDisponivel_Possui_Comportamento_De_Nice_Mock(){
        int actual = servicoDeReserva.getQuantidadeDisponivel();

        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void Deve_Testar_Se_O_Metodo_efetuarReserva_Funciona_Com_Input_De_Pagamento_Adiantado(){
        ReservaInput input = new ReservaInput("114", of(2021, 5, 10),
                of(2021,6,10), 3, true);

        ServicoDeQuarto servicoDeQuarto = mock(ServicoDeQuarto.class);
        ServicoDePagamentos servicoDePagamentos = mock(ServicoDePagamentos.class);
        ReservaDAO reservaDAO = mock(ReservaDAO.class);
        EnviadorDeEmail enviadorDeEmail = mock(EnviadorDeEmail.class);

        ServicoDeReserva servicoDeReserva = new ServicoDeReserva(servicoDePagamentos,servicoDeQuarto, reservaDAO, enviadorDeEmail);

        servicoDeReserva.efetuarReserva(input);

        assertAll(
                () -> verify(servicoDePagamentos, times(1)).pagar(any(), anyDouble()),
                () -> verify(servicoDeQuarto, times(1)).buscarQuartoDisponivelPorId(any()),
                () -> verify(servicoDeQuarto, times(1)).reservarQuarto(any()),
                () -> verify(reservaDAO, times(1)).salvar(any()),
                () -> verify(enviadorDeEmail, times(1)).enviarConfirmacaoReserva(any())
        );
    }
}