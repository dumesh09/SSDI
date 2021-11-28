package ssdi.group7.organdonationsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssdi.group7.organdonationsystem.exception.ResourceNotFoundException;
import ssdi.group7.organdonationsystem.model.PowerOfAttorney;
import ssdi.group7.organdonationsystem.repository.PowerOfAttorneyRepository;

@Component
public class PowerOfAttorneyService {
	
	@Autowired 
	private PowerOfAttorneyRepository poaRepository;
	
    public List<PowerOfAttorney> getAllPOA() {
        return poaRepository.findAll();
    }

	public PowerOfAttorney getPOAById(Long poaId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		PowerOfAttorney poa = poaRepository.findById(poaId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + poaId));
        return poa;
	}

	public PowerOfAttorney createPOA(PowerOfAttorney poa) {
		// TODO Auto-generated method stub
		return poaRepository.save(poa);
	}

	public PowerOfAttorney updatePOA(Long poaId, PowerOfAttorney poaDetails) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		PowerOfAttorney poa = poaRepository.findById(poaId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + poaId));
		
		poa.setEmail(poaDetails.getEmail());
		poa.setLastName(poaDetails.getLastName());
		poa.setFirstName(poaDetails.getFirstName());
		poa.setId(poaId);
		poa.setPhone(poaDetails.getPhone());
		poa.setRelation(poaDetails.getRelation());
		poa.setUserId(poa.getUserId());
		final PowerOfAttorney updatedPOA = poaRepository.save(poa);
		return updatedPOA;
	}

	public Map<String, Boolean> deletePOA(Long poaId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		PowerOfAttorney poa = poaRepository.findById(poaId)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + poaId));
		poaRepository.delete(poa);
		 Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	}

}
