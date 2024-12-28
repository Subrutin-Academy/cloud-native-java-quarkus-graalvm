package com.subrutin.lingkar.catalog.domain;

import java.util.UUID;

import com.fasterxml.uuid.Generators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "secure_id", unique = true, nullable = false)
    private UUID secureId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique=true)
    private String email;

    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "deleted",columnDefinition = "boolean default false not null")
    private Boolean deleted;

    
    @PrePersist
    public void prePersist(){
        this.deleted=Boolean.FALSE;
        if(this.secureId==null){
            secureId = Generators.timeBasedEpochGenerator().generate();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSecureId() {
        return secureId;
    }

    public void setSecureId(UUID secureId) {
        this.secureId = secureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    

}
