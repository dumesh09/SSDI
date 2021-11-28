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
import ssdi.group7.organdonationsystem.model.Transplant;
import ssdi.group7.organdonationsystem.service.TransplantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TransplantController {

	@Autowired
	private TransplantService transplantService;

	@GetMapping("/transplant")
	public List<Transplant> getAllTransplants() {
		return transplantService.getAllTransplant();
	}

	@GetMapping("/transplant/{id}")
	public ResponseEntity<Transplant> getTransplantById(@PathVariable(value = "id") Long transplantId)
			throws ResourceNotFoundException {
		Transplant transplant = transplantService.getTransplantById(transplantId);
		return ResponseEntity.ok().body(transplant);
	}

	@PostMapping("/transplant")
	public Transplant createTransplant(@Validated @RequestBody Transplant transplant) {
		return transplantService.createTransplant(transplant);
	}

	@PutMapping("/transplant/{id}")
	public ResponseEntity<Transplant> updateTransplant(@PathVariable(value = "id") Long transplantId,
			@Validated @RequestBody Transplant transplantDetails) throws ResourceNotFoundException {
		Transplant transplant = transplantService.updateTransplant(transplantId, transplantDetails);
		return ResponseEntity.ok(transplant);
	}

	@DeleteMapping("/transplant/{id}")
	public Map<String, Boolean> deleteTransplant(@PathVariable(value = "id") Long transplantId)
			throws ResourceNotFoundException {

		return transplantService.deleteTransplant(transplantId);
	}

}
