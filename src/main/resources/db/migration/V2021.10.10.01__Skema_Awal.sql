CREATE TABLE barang (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    status_record character varying(255),
    updated timestamp without time zone,
    updated_by character varying(255),
    code character varying(20) NOT NULL,
    name character varying(255) NOT NULL,
    qty integer NOT NULL,
    CONSTRAINT barang_qty_check CHECK ((qty >= 0))
);
ALTER TABLE ONLY barang
    ADD CONSTRAINT barang_pkey PRIMARY KEY (id);
ALTER TABLE barang
ADD CONSTRAINT b_unique_code UNIQUE (code);

CREATE TABLE customer (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    status_record character varying(255),
    updated timestamp without time zone,
    updated_by character varying(255),
    code character varying(20) NOT NULL,
    name character varying(255) NOT NULL,
    phone_number character varying(20) NOT NULL
);
ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
ALTER TABLE customer
ADD CONSTRAINT customer_unique_code UNIQUE (code);

CREATE TABLE transaksi (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    status_record character varying(255),
    updated timestamp without time zone,
    updated_by character varying(255),
    code character varying(20) NOT NULL,
    invoice_type character varying(255) NOT NULL,
    qty integer NOT NULL,
    id_barang character varying(255),
    id_customer character varying(255),
    CONSTRAINT transaksi_qty_check CHECK ((qty >= 0))
);
ALTER TABLE ONLY transaksi
    ADD CONSTRAINT transaksi_pkey PRIMARY KEY (id);
ALTER TABLE ONLY transaksi
    ADD CONSTRAINT fk2aqd3mmk3k33ja6bn8ttxsn4h FOREIGN KEY (id_customer) REFERENCES customer(id);
ALTER TABLE ONLY transaksi
    ADD CONSTRAINT fk5sx80v9epd17imm1k0xqwgo1y FOREIGN KEY (id_barang) REFERENCES barang(id);
ALTER TABLE transaksi
ADD CONSTRAINT t_unique_code UNIQUE (code);

CREATE TABLE staging (
    id character varying(36) NOT NULL,
    created timestamp without time zone,
    created_by character varying(255),
    status_record character varying(255),
    updated timestamp without time zone,
    updated_by character varying(255),
    code character varying(20) NOT NULL,
    qty integer NOT NULL,
    id_barang character varying(255) NOT NULL,
    id_customer character varying(255) NOT NULL,
    id_transaksi character varying(255) NOT NULL,
    CONSTRAINT staging_qty_check CHECK ((qty >= 0))
);
ALTER TABLE ONLY staging
    ADD CONSTRAINT staging_pkey PRIMARY KEY (id);
ALTER TABLE ONLY staging
    ADD CONSTRAINT fk270u1o5p5ic4tvco14pxkkqsp FOREIGN KEY (id_barang) REFERENCES barang(id);
ALTER TABLE ONLY staging
    ADD CONSTRAINT fkfaxlu3ivo2rts6o6p9geh95oe FOREIGN KEY (id_transaksi) REFERENCES transaksi(id);
ALTER TABLE ONLY staging
    ADD CONSTRAINT fkm16k3fyeovfm47jy8rvklr2sp FOREIGN KEY (id_customer) REFERENCES customer(id);
ALTER TABLE staging
ADD CONSTRAINT s_unique_code UNIQUE (code);

CREATE table running_number(
    id character varying (36),
    prefix character varying (20) not null,
    last_number bigint
);
ALTER TABLE ONLY running_number
    ADD CONSTRAINT running_number_pkey PRIMARY KEY (id);
ALTER TABLE running_number
ADD CONSTRAINT rn_unique_code UNIQUE (prefix);