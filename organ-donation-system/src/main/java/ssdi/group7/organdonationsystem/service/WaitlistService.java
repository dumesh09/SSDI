package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Waitlist;
import ssdi.group7.organdonationsystem.repository.WaitlistRepository;

@Component
public class WaitlistService {

	@Autowired
	WaitlistRepository waitlistRepository;
	
	public List<Waitlist> getAllWaitlist() {
		return waitlistRepository.findAll();
	}

	public Waitlist getWaitlistById(Long waitlistId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Waitlist waitlist = waitlistRepository.findById(waitlistId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + waitlistId));
		return waitlist;
	}

	public Waitlist createWaitlist(Waitlist waitlist) {
		// TODO Auto-generated method stub
		return waitlistRepository.save(waitlist);
	}

	public Waitlist updateWaitlist(Long waitlistId, Waitlist waitlistDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Waitlist waitlist = waitlistRepository.findById(waitlistId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + waitlistId));

		waitlist.setOrganId(waitlistDetails.getOrganId());
		waitlist.setScore(waitlistDetails.getScore());
		waitlist.setUserId(waitlistDetails.getUserId());
		final Waitlist updatedWaitlist = waitlistRepository.save(waitlist);
		return updatedWaitlist;
	}

	public Map<String, Boolean> deleteWaitlist(Long waitlistId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Waitlist waitlist = waitlistRepository.findById(waitlistId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + waitlistId));
		waitlistRepository.delete(waitlist);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
