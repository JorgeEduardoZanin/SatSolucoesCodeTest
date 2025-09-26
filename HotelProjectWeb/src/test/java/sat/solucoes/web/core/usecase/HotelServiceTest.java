package sat.solucoes.web.core.usecase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sat.solucoes.web.core.domain.HotelDomain;
import sat.solucoes.web.core.port.out.HotelRepository;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    @Captor
    private ArgumentCaptor<HotelDomain> hotelArgumentCaptor;

    
    private HotelDomain createSampleHotel() {
        HotelDomain h = new HotelDomain();
        h.setAddress("Rua Exemplo, 123");
        h.setCity("São Paulo");
        h.setNumber("123");
        h.setState("SP");
        h.setEmail("hotel@example.com");
        h.setPassword("plainPassword");
        return h;
    }

    @Nested
    @DisplayName("create")
    class Create {

        @Test
        @DisplayName("Should create hotel and encode password")
        void shouldCreateHotelAndEncodePassword() {
            HotelDomain hotel = createSampleHotel();

            doReturn("senhaEncriptada").when(passwordEncoder).encode("senhaCrua");

            hotelService.create(hotel);

            verify(passwordEncoder, times(1)).encode("senhaCrua");
            verify(hotelRepository, times(1)).create(hotelArgumentCaptor.capture());

            HotelDomain captured = hotelArgumentCaptor.getValue();
            assertNotNull(captured);
            assertEquals("senhaEncriptada", captured.getPassword());
        }

        @Test
        @DisplayName("Should throw when hotel is null")
        void shouldThrowWhenHotelIsNull() {
            assertThrows(NullPointerException.class, () -> hotelService.create(null));
        
            verify(hotelRepository, times(0)).create(any());
        }
    }

    @Nested
    @DisplayName("findById")
    class FindById {

        @Test
        @DisplayName("Should return hotel when found")
        void shouldReturnHotelWhenFound() {
            long id = 1L;
            HotelDomain hotel = createSampleHotel();

            doReturn(hotel).when(hotelRepository).findById(id);

            var response = hotelService.findById(id);

            assertNotNull(response);
            assertEquals(hotel.getEmail(), response.getEmail());
            verify(hotelRepository, times(1)).findById(id);
        }

        @Test
        @DisplayName("Should return null when not found")
        void shouldReturnNullWhenNotFound() {
            long id = 999L;
            doReturn(null).when(hotelRepository).findById(id);

            var response = hotelService.findById(id);

            // service just returns repository result (null)
            assertEquals(null, response);
            verify(hotelRepository, times(1)).findById(id);
        }
    }

    @Nested
    @DisplayName("findAllPaginate")
    class FindAllPaginate {

        @Test
        @DisplayName("Should return paginated list")
        void shouldReturnPaginatedList() {
            List<HotelDomain> list = new ArrayList<>();
            list.add(createSampleHotel());
            list.add(createSampleHotel());

            doReturn(list).when(hotelRepository).findAllPaginate(0, 10);

            var response = hotelService.findAllPaginate(0, 10);

            assertNotNull(response);
            assertEquals(2, response.size());
            verify(hotelRepository, times(1)).findAllPaginate(0, 10);
        }
    }

    @Nested
    @DisplayName("update")
    class Update {

        @Test
        @DisplayName("Should update hotel fields and call repository.update")
        void shouldUpdateHotelFieldsAndCallRepositoryUpdate() {
            long id = 5L;

       
            HotelDomain oldHotel = new HotelDomain();
            oldHotel.setAddress("Endereco antigo");
            oldHotel.setCity("Cidade Antiga");
            oldHotel.setNumber("000");
            oldHotel.setState("PR");
            oldHotel.setEmail("antigo@gmail.com");

     
            HotelDomain newHotel = new HotelDomain();
            newHotel.setAddress("Novo endereco");
            newHotel.setCity("Nova cidade");
            newHotel.setNumber("111");
            newHotel.setState("DF");
            newHotel.setEmail("novo@gmail.com");

   
            doReturn(oldHotel).when(hotelRepository).findById(id);
            doReturn(oldHotel).when(hotelRepository).update(any(HotelDomain.class));

            var result = hotelService.update(newHotel, id);

            verify(hotelRepository, times(1)).findById(id);
            verify(hotelRepository, times(1)).update(hotelArgumentCaptor.capture());

            HotelDomain captured = hotelArgumentCaptor.getValue();
            assertEquals("Novo endereco", captured.getAddress());
            assertEquals("Nova cidade", captured.getCity());
            assertEquals("111", captured.getNumber());
            assertEquals("DF", captured.getState());
            assertEquals("novo@gmail.com", captured.getEmail());

            assertNotNull(result);
        }

        @Test
        @DisplayName("Should throw when incoming hotel is null")
        void shouldThrowWhenIncomingNull() {
            long id = 1L;
            assertThrows(NullPointerException.class, () -> hotelService.update(null, id));
            verify(hotelRepository, times(0)).update(any());
        }

        @Test
        @DisplayName("Should throw when domain not found in repo")
        void shouldThrowWhenDomainNotFound() {
            long id = 123L;
            HotelDomain incoming = createSampleHotel();

            doReturn(null).when(hotelRepository).findById(id);

            assertThrows(NullPointerException.class, () -> hotelService.update(incoming, id));
            verify(hotelRepository, times(1)).findById(id);
            verify(hotelRepository, times(0)).update(any());
        }
    }

    @Nested
    @DisplayName("delete")
    class Delete {

        @Test
        @DisplayName("Should call repository.delete")
        void shouldCallRepositoryDelete() {
            long id = 10L;
            assertDoesNotThrow(() -> hotelService.delete(id));
            verify(hotelRepository, times(1)).delete(id);
        }
    }

    @Nested
    @DisplayName("findHotelByEmail")
    class FindHotelByEmail {

        @Test
        @DisplayName("Should return hotel when found by email")
        void shouldReturnHotelWhenFoundByEmail() {
            String email = "hotel@gmail.com";
            HotelDomain hotel = createSampleHotel();

            doReturn(hotel).when(hotelRepository).findHotelByEmail(email);

            var response = hotelService.findHotelByEmail(email);

            assertNotNull(response);
            assertEquals(email, response.getEmail());
            verify(hotelRepository, times(1)).findHotelByEmail(email);
        }

        @Test
        @DisplayName("Should return null when not found by email")
        void shouldReturnNullWhenNotFoundByEmail() {
            String email = "naoencontrnado@gmail.com";
            doReturn(null).when(hotelRepository).findHotelByEmail(email);

            var response = hotelService.findHotelByEmail(email);

            assertEquals(null, response);
            verify(hotelRepository, times(1)).findHotelByEmail(email);
        }
    }
}

