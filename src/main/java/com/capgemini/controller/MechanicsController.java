package com.capgemini.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Mechanics;
import com.capgemini.repository.MechanicsRepository;
import com.capgemini.service.MechanicsServiceImpl;

@RestController
@RequestMapping("/api/mechanics/")
@CrossOrigin
public class MechanicsController {
	
	@Autowired
	private MechanicsServiceImpl mechanicsServiceimpl;
	
	@PostMapping("/")
	public String create(@RequestBody Mechanics mechanics) {
		
		return mechanicsServiceimpl.createMechanics(mechanics);
	}
	
	@PutMapping("/{mechanicsId}")
	public String update(@PathVariable int mechanicsId,@RequestBody Mechanics mechanics ) {
		
		return mechanicsServiceimpl.updateMechanics(mechanicsId, mechanics);
}
	@GetMapping("/{mechanicsId}")
	public Mechanics findById(@PathVariable int mechanicsId) {
		
		return mechanicsServiceimpl.findMechanicsbyId(mechanicsId);
	}
	
	@GetMapping("/")
	public List<Mechanics> getRequest(){
		return mechanicsServiceimpl.getRequest();
	}
	
	@DeleteMapping("/{mechanicsId}")
	public String deleteUser(@PathVariable int mechanicsId) {
		return mechanicsServiceimpl.deleteMechanic(mechanicsId);
	}

}
