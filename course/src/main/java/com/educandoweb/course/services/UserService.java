package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public List<com.educandoweb.course.entities.User> findAll(){
		return repository.findAll();
	}
	
	public com.educandoweb.course.entities.User findById(Long id) {
		Optional<com.educandoweb.course.entities.User> obj = repository.findById(id);
		return obj.get();
		}
	
	public User insert(User obj) {
		return repository.save(obj);
	}

	public com.educandoweb.course.entities.User insert(com.educandoweb.course.entities.User obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public com.educandoweb.course.entities.User update(Long id, com.educandoweb.course.entities.User obj) {
		com.educandoweb.course.entities.User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(com.educandoweb.course.entities.User entity, com.educandoweb.course.entities.User obj) {
		entity.setName(obj.getName());
	
		
		
	}
}
