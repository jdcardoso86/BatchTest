package com.ar.myBatchService.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BaseEntity implements Serializable {
    @Id
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }

    public BaseEntity(Long id) {
        this.id = id;
    }
}
