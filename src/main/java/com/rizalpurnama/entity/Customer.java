package com.rizalpurnama.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity @Data
@SQLDelete(sql = "UPDATE barang SET status_record = 'INACTIVE' where id=?")
@Where(clause = "status_record='ACTIVE'")
public class Customer extends BaseEntity{
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String code;

    @NotNull @NotEmpty @Size(min = 3, max = 255)
    private String name;

    @NotNull @Size(max = 20)
    private String phoneNumber;
}
