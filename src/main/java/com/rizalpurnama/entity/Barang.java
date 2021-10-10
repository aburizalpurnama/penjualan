package com.rizalpurnama.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity @Data
@SQLDelete(sql = "UPDATE barang SET status_record = 'INACTIVE' where id=?")
@Where(clause = "status_record='ACTIVE'")
public class Barang extends BaseEntity{

    @NotNull @NotEmpty
    @Size(max = 20)
    private String code;

    @NotNull @NotEmpty @Size(min = 3, max = 255)
    private String name;

    @NotNull @Min(0)
    private int qty;
}
