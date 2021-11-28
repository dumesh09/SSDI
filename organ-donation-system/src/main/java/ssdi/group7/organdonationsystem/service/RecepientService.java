package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Recepient;
import ssdi.group7.organdonationsystem.repository.RecepientRepository;

@Component
public class RecepientService {

	@Autowired
	private RecepientRepository recepientRepository;
	
	public List<Recepient> getAllRecepient() {
		return recepientRepository.findAll();
	}

	public Recepient getRecepientById(Long donarId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Recepient donar = recepientRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));
		return donar;
	}

	public Recepient createRecepient(Recepient donar) {
		// TODO Auto-generated method stub
		return recepientRepository.save(donar);
	}

	public Recepient updateRecepient(Long donarId, Recepient donarDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Recepient donar = recepientRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));

		donar.setOrganId(donarDetails.getOrganId());
		donar.setRecepientId(donarDetails.getRecepientId());
		final Recepient updatedRecepient = recepientRepository.save(donar);
		return updatedRecepient;
	}

	public Map<String, Boolean> deleteRecepient(Long donarId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Recepient donar = recepientRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));
		recepientRepository.delete(donar);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
