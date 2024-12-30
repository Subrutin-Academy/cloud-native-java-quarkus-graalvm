package com.subrutin.lingkar.catalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Column(name = "deleted", columnDefinition = "boolean default false not null")
    private Boolean deleted;

    @PrePersist
    public void prePersist() {
        this.deleted = Boolean.FALSE;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
