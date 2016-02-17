package com.zjs.cashretracted.service;

import java.util.List;
import com.zjs.cashretracted.model.Role;


public interface RoleService {
	 
		public void persistRole(Role role);	  
		public  Role findRoleById(Integer id );	 
		public  Role updateRole(Role role); 
		public  void deleteRole(Role role);
		public void detacherRole(Role role);
		public List<Role> getAllRoles();
		

}
