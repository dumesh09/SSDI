package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Transplant;
import ssdi.group7.organdonationsystem.repository.TransplantRepository;

@Component
public class TransplantService {

	@Autowired
	TransplantRepository transplantRepository;

	public List<Transplant> getAllTransplant() {
		return transplantRepository.findAll();
	}

	public Transplant getTransplantById(Long transplantId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Transplant transplant = transplantRepository.findById(transplantId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + transplantId));
		return transplant;
	}

	public Transplant createTransplant(Transplant transplant) {
		// TODO Auto-generated method stub
		return transplantRepository.save(transplant);
	}

	public Transplant updateTransplant(Long transplantId, Transplant transplantDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Transplant transplant = transplantRepository.findById(transplantId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + transplantId));

		transplant.setDonarId(transplantDetails.getDonarId());
		transplant.setOrganId(transplantDetails.getOrganId());
		transplant.setRecepientId(transplantDetails.getRecepientId());
		final Transplant updatedTransplant = transplantRepository.save(transplant);
		return updatedTransplant;
	}

	public Map<String, Boolean> deleteTransplant(Long transplantId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Transplant transplant = transplantRepository.findById(transplantId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + transplantId));
		transplantRepository.delete(transplant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
