package ssdi.group7.organdonationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssdi.group7.organdonationsystem.model.Donar;

@Repository
public interface DonarRepository extends JpaRepository<Donar, Long> {

}
