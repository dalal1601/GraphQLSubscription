package dao.repositories;

import dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
