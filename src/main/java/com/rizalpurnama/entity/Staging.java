package com.rizalpurnama.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.List;

@Entity @Data
@SQLDelete(sql = "UPDATE staging SET status_record = 'INACTIVE' where id=?")
@Where(clause = "status_record='ACTIVE'")
public class Staging extends BaseEntity {
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String code;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @NotNull @Min(0)
    private int qty;
}
