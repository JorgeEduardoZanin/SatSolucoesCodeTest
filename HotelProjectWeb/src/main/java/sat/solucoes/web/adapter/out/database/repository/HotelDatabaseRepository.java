package sat.solucoes.web.adapter.out.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sat.solucoes.web.adapter.out.database.entity.HotelEntity;

public interface HotelDatabaseRepository extends JpaRepository<HotelEntity, Long>{

}
