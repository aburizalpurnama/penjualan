package com.rizalpurnama.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity @Data
@SQLDelete(sql = "UPDATE transaksi SET status_record = 'INACTIVE' where id=?")
@Where(clause = "status_record='ACTIVE'")
public class Transaksi extends BaseEntity{
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @Size(max = 36)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_barang")
    @Size(max = 36)
    private Barang barang;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Size(max = 10)
    private InvoiceType invoiceType = InvoiceType.DIRECT;

    @NotNull @Min(0)
    private int qty;
}
