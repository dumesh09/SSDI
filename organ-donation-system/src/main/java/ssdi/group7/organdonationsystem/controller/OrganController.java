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
import ssdi.group7.organdonationsystem.model.Organ;
import ssdi.group7.organdonationsystem.service.OrganService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class OrganController {
   
	@Autowired 
	private OrganService organService;
	
    @GetMapping("/organ")
    public List<Organ> getAllOrgan() {
        return organService.getAllOrgans();
    }
    
    @GetMapping("/organ/{id}")
    public ResponseEntity<Organ> getOrganById(@PathVariable(value = "id") Long organId)
        throws ResourceNotFoundException {
        Organ organ = organService.getOrganById(organId);
        return ResponseEntity.ok().body(organ);
    }
    
    @PostMapping("/organ")
    public Organ createOrgan(@Validated @RequestBody Organ organ) {
        return organService.createOrgan(organ);
    }
    
    @PutMapping("/organ/{id}")
    public ResponseEntity<Organ> updateOrgan(@PathVariable(value = "id") Long organId,
         @Validated @RequestBody Organ organDetails) throws ResourceNotFoundException {
        Organ organ = organService.updateOrgan(organId,organDetails);
        return ResponseEntity.ok(organ);
    }
    
    @DeleteMapping("/organ/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long organId)
         throws ResourceNotFoundException {
    	
    	return organService.deleteOrgan(organId);
    }
    
}
