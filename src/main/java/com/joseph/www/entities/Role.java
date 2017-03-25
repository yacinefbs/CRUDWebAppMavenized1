package com.joseph.www.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;


@Entity
public class Role implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRole;
	private String rolename;
	
	
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@PreRemove
	private void removeAssociationsWithChilds() {
		for (User u : users) {
	        u.setRoles(null);
	   }
	}
	
//	@ManyToMany
//	@JoinTable(name = "USER_ROLE", 
//            joinColumns = { @JoinColumn(name = "USER_ID") }, 
//            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
//   private List<User> users = new ArrayList<User>();
	
	
	public Role(){
		
		
		
	}



	public Long getIdRole() {
		return idRole;
	}



	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}



	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
}
