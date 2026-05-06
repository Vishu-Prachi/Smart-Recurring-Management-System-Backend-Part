package com.cs.demo.cntrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.Entity.Rduser;

import com.cs.demo.repo.Rduserrepo;

@RestController
public class Rduser_cntrl {
	
	@Autowired
	private Rduserrepo repo;
	
	@GetMapping("rduser")
	public List<Rduser> pb(){
		List<Rduser> lst=repo.findAll();
		return lst;
	}
	
	@GetMapping("/rduserByid/{id}")
	public Rduser pbid(@PathVariable("id") int id) {
	    return repo.findById(id).orElse(null);
	}
	
	@PostMapping("/save")
	public Rduser saverd (@RequestBody Rduser p) {
		return repo.save(p);
	}
	
	@PutMapping("/updt")
	public Rduser updtrd (@RequestBody Rduser p) {
		return repo.save(p);
	}
	
	@DeleteMapping("/dlt/{id}")
	public String deleteBlg(@PathVariable("id") int id) {
			repo.deleteById(id);
			return "Record Deleted Sucessfully........";
		}
	}


