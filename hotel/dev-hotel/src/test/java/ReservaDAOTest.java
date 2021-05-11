import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.time.LocalDate.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ReservaDAOTest {

    ReservaDAO reservaDAO;

    @BeforeEach
    public void setup(){
        reservaDAO = mock(ReservaDAO.class);
    }

    @Test
    void Deve_Testar_Retorno_Do_Metodo_Salvar(){

        ReservaInput input = new ReservaInput("114", of(2021, 5, 10),
                of(2021,6,10), 3, false);

       doReturn(UUID.randomUUID().toString()).when(reservaDAO).salvar(input);

       String actual =  reservaDAO.salvar(input);

        assertNotEquals(null, actual);
    }

}