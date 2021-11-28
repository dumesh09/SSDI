package ssdi.group7.organdonationsystem.controller;

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
import ssdi.group7.organdonationsystem.model.PowerOfAttorney;
import ssdi.group7.organdonationsystem.service.PowerOfAttorneyService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PowerOfAttorneyController {
	
	@Autowired
	private PowerOfAttorneyService poaService;
	
    @GetMapping("/poa/{id}")
    public ResponseEntity<PowerOfAttorney> getPOAById(@PathVariable(value = "id") Long poaId)
        throws ResourceNotFoundException {
    	PowerOfAttorney poa = poaService.getPOAById(poaId);
        return ResponseEntity.ok().body(poa);
    }
    
    @PostMapping("/poa")
    public PowerOfAttorney createPOA(@Validated @RequestBody PowerOfAttorney poa) {
        return poaService.createPOA(poa);
    }
    
    @PutMapping("/poa/{id}")
    public ResponseEntity<PowerOfAttorney> updatePOA(@PathVariable(value = "id") Long poaId,
         @Validated @RequestBody PowerOfAttorney poaDetails) throws ResourceNotFoundException {
    	PowerOfAttorney poa = poaService.updatePOA(poaId, poaDetails);
        return ResponseEntity.ok(poa);
    }
    
    @DeleteMapping("/poa/{id}")
    public Map<String, Boolean> deletePOA(@PathVariable(value = "id") Long poaId)
         throws ResourceNotFoundException {
    	
    	return poaService.deletePOA(poaId);
    }
}
