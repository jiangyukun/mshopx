package com.gxkj.projects.myshopx.entitys;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rel_admin_user_role")
public class RelAdminUserRole  implements Serializable{

	private static final long serialVersionUID = 1419160305567096343L;

	@Embedded
	@Id
	private  RelAdminUserRolePK relAdminUserRolePK;//

	public RelAdminUserRolePK getRelAdminUserRolePK() {
		return relAdminUserRolePK;
	}

	public void setRelAdminUserRolePK(RelAdminUserRolePK relAdminUserRolePK) {
		this.relAdminUserRolePK = relAdminUserRolePK;
	}
}
