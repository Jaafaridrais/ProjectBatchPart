package com.zjs.cashretracted.dao;

import java.util.List;
import com.zjs.cashretracted.model.Role;


public interface RoleDAO {
	 
		public void persistRole(Role role);	  
		public  Role findRoleById(Integer id );	 
		public  Role updateRole(Role role); 
		public  void deleteRole(Role role);
		public void detacherRole(Role role);
		public List<Role> getAllRoles();
		

}
