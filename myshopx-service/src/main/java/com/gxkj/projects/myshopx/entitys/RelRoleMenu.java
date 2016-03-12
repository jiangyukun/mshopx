package com.gxkj.projects.myshopx.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rel_role_menu")
public class RelRoleMenu   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2831251690697317683L;


	@Id
	@GenericGenerator(name="session_info_uuid_gen",strategy="assigned")
	@GeneratedValue(generator="session_info_uuid_gen")
	@Column(name="menuid" )
	private String menuid;

	@Id
	@GenericGenerator(name="session_info_uuid_gen",strategy="assigned")
	@GeneratedValue(generator="session_info_uuid_gen")
	@Column(name="roleid" )
	private String roleid;
	


	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	

}
