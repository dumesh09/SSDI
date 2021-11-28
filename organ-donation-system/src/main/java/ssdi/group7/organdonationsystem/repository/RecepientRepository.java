package ssdi.group7.organdonationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssdi.group7.organdonationsystem.model.Recepient;

@Repository
public interface RecepientRepository extends JpaRepository<Recepient, Long>  {

}
