package com.gxkj.projects.myshopx.entitys;



import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by dell on 2016/1/19.
 */
@MappedSuperclass
public abstract class BaseModel implements   Serializable {

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(name = "id")
    private String id;


    @Column(name="create_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP )
    private Date createdAt;

    @Column(name="update_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP )
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = new Date();
    }


    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass())
            return false;

        return this.getId().equals(((BaseModel) other).getId());
    }


    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
