package ssdi.group7.organdonationsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Waitlist;
import ssdi.group7.organdonationsystem.service.WaitlistService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class WaitlistController {
	
	@Autowired
	WaitlistService waitlistService;
	
	@GetMapping("/waitlist")
	public List<Waitlist> getAllWaitlists() {
		return waitlistService.getAllWaitlist();
	}

	@GetMapping("/waitlist/{id}")
	public ResponseEntity<Waitlist> getWaitlistById(@PathVariable(value = "id") Long waitlistId)
			throws ResourceNotFoundException {
		Waitlist waitlist = waitlistService.getWaitlistById(waitlistId);
		return ResponseEntity.ok().body(waitlist);
	}

	@PostMapping("/waitlist")
	public Waitlist createWaitlist(@Validated @RequestBody Waitlist waitlist) {
		return waitlistService.createWaitlist(waitlist);
	}

	@PutMapping("/waitlist/{id}")
	public ResponseEntity<Waitlist> updateWaitlist(@PathVariable(value = "id") Long waitlistId,
			@Validated @RequestBody Waitlist waitlistDetails) throws ResourceNotFoundException {
		Waitlist waitlist = waitlistService.updateWaitlist(waitlistId, waitlistDetails);
		return ResponseEntity.ok(waitlist);
	}

	@DeleteMapping("/waitlist/{id}")
	public Map<String, Boolean> deleteWaitlist(@PathVariable(value = "id") Long waitlistId)
			throws ResourceNotFoundException {

		return waitlistService.deleteWaitlist(waitlistId);
	}


}
