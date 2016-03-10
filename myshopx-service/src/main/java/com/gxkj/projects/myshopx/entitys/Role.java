package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.RoleState;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseModel{


    private static final long serialVersionUID = -3689074768403916789L;

    @NotBlank(message="{Role.name.blank}")
    @Column(name="name")
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private RoleState state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleState getState() {
        return state;
    }

    public void setState(RoleState state) {
        this.state = state;
    }
}
