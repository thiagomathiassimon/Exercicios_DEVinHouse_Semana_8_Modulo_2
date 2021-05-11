import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

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
}