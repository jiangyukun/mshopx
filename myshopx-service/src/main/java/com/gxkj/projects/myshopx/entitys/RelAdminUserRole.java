package com.gxkj.projects.myshopx.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rel_admin_user_role")
public class RelAdminUserRole  implements Serializable{

	private static final long serialVersionUID = 1419160305567096343L;

	@Id
	@GenericGenerator(name="session_info_uuid_gen",strategy="assigned")
	@GeneratedValue(generator="session_info_uuid_gen")
	@Column(name="user_id" )
	private int userId;

	@Id
	@GenericGenerator(name="session_info_uuid_gen",strategy="assigned")
	@GeneratedValue(generator="session_info_uuid_gen")
	@Column(name="admin_role_id" )
	private int adminRoleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAdminRoleId() {
		return adminRoleId;
	}

	public void setAdminRoleId(int adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
}
