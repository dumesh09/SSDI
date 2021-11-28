package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Organ;
import ssdi.group7.organdonationsystem.repository.OrganRepository;

@Component
public class OrganService {

	@Autowired
	private OrganRepository organRepository;

	public List<Organ> getAllOrgans() {
		return organRepository.findAll();
	}

	public Organ getOrganById(Long organId) throws ResourceNotFoundException {
		Organ organ = organRepository.findById(organId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + organId));
		return organ;
	}

	public Organ createOrgan(Organ organ) {
		return organRepository.save(organ);
	}

	public Organ updateOrgan(Long organId, Organ organDetails) throws ResourceNotFoundException {
		Organ organ = organRepository.findById(organId)
				.orElseThrow(() -> new ResourceNotFoundException("Organ not found for this id :: " + organId));
		organ.setBloodType(organDetails.getBloodType());
		organ.setOrganName(organDetails.getOrganName());

		final Organ updatedOrgan = organRepository.save(organ);
		return updatedOrgan;
	}

	public Map<String, Boolean> deleteOrgan(Long organId) throws ResourceNotFoundException {
		Organ organ = organRepository.findById(organId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + organId));
		organRepository.delete(organ);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
