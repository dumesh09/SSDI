package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.Donar;
import ssdi.group7.organdonationsystem.repository.DonarRepository;

@Component
public class DonarService {
	
	@Autowired
	private DonarRepository donarRepository;

	public List<Donar> getAllDonar() {
		return donarRepository.findAll();
	}

	public Donar getDonarById(Long donarId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Donar donar = donarRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));
		return donar;
	}

	public Donar createDonar(Donar donar) {
		// TODO Auto-generated method stub
		return donarRepository.save(donar);
	}

	public Donar updateDonar(Long donarId, Donar donarDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Donar donar = donarRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));

		donar.setOrganId(donarDetails.getOrganId());
		donar.setDonarId(donarDetails.getDonarId());
		final Donar updatedDonar = donarRepository.save(donar);
		return updatedDonar;
	}

	public Map<String, Boolean> deleteDonar(Long donarId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Donar donar = donarRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + donarId));
		donarRepository.delete(donar);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
