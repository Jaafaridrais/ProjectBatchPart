package com.zjs.cashretracted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjs.cashretracted.dao.RoleDAO;
import com.zjs.cashretracted.model.Role;
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO ;
	@Transactional
	public void persistRole(Role role) {
		roleDAO.persistRole(role);

	}
	@Transactional
	public Role findRoleById(Integer id) {
		Role role = roleDAO.findRoleById(id);
		detacherRole(role);
		return role;
	}
	@Transactional
	public Role updateRole(Role role) {
		return roleDAO.updateRole(role);
	}
	@Transactional
	public void deleteRole(Role role) {
		roleDAO.deleteRole(role);

	}
	@Transactional
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}
	@Transactional
	public void detacherRole(Role role) {
		roleDAO.detacherRole(role);
		
	}

}
