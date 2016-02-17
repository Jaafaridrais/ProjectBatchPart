package com.zjs.cashretracted.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zjs.cashretracted.model.Role;


@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void persistRole(Role role) {
		sessionFactory.getCurrentSession().persist(role);

	}

	public Role findRoleById(Integer id) {
		
		 return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	public Role updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
		return role;
	}

	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);

	}
	public void detacherRole(Role role) {
		sessionFactory.getCurrentSession().evict(role);
		
	}
	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		Query query = sessionFactory.getCurrentSession().createQuery("from role");
		return query.list();
	}

}
