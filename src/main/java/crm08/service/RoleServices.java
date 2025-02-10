package crm08.service;

import java.util.List;

import crm08.repository.RoleRepository;
import entity.RoleEntity;

public class RoleServices {
	private RoleRepository roleRepository = new RoleRepository();
	
	public List<RoleEntity> getRole(){
		List<RoleEntity> roles = roleRepository.findAll();
		
		return roles;
	}
}
