package com.finallab2.basquet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carnet")
public class Carnet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcarnet")
    private int idcarnet;

    @Column(name = "aniodeseguro")
    private int aniodeseguro;

    @Column(name = "idjugador")
    private int idjugador;


    public int getIdcarnet() {
        return idcarnet;
    }

    public void setIdcarnet(int idcarnet) {
        this.idcarnet = idcarnet;
    }

    public int getAnioDeSeguro() {
        return aniodeseguro;
    }

    public void setgetAnioDeSeguro(int aniodeseguro) {
        this.aniodeseguro = aniodeseguro;
    }

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }
}
