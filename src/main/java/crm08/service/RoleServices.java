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
	
	public boolean isRoleNameExists(String name) {
        return roleRepository.findByName(name) != null;
    }

	public boolean insertRole(String name, String description) {
		return roleRepository.insertRole(name, description) > 0;
    }
	
}
