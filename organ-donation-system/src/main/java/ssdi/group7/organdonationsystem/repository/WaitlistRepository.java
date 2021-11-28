package ssdi.group7.organdonationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssdi.group7.organdonationsystem.model.Waitlist;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Long>  {

}
