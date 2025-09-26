package sat.solucoes.web.adapter.out.database.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sat.solucoes.web.adapter.dto.response.hotel.HotelFindAllResponse;
import sat.solucoes.web.adapter.out.database.entity.HotelEntity;
import sat.solucoes.web.adapter.out.database.response.HotelLoginResponse;

@Repository
public interface HotelDatabaseRepository extends JpaRepository<HotelEntity, Long>{

	@Query("SELECT new sat.solucoes.web.adapter.dto.response.hotel.HotelFindAllResponse(h.name, h.city, h.state) FROM HotelEntity h")
	Page<HotelFindAllResponse> findAllPaginated(Pageable pageable);
	
	@Query("SELECT new sat.solucoes.web.adapter.out.database.response.HotelLoginResponse(h.name, h.password ,h.email, h.id) FROM HotelEntity h WHERE h.email = :email")
	HotelLoginResponse findHotelByEmail(@Param("email") String email);
}
