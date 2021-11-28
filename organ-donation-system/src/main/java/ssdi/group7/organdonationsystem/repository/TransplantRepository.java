package ssdi.group7.organdonationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssdi.group7.organdonationsystem.model.Transplant;

@Repository
public interface TransplantRepository extends JpaRepository<Transplant, Long> {

}
