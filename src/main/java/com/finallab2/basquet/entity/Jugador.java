package com.finallab2.basquet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.Image;
import java.sql.Blob;
import java.util.Date;


/**
 * Created by WIZERWOLF on 6/7/2017.
 */
@Entity
@Table(name="jugador")
public class Jugador {
    @Id
    @GeneratedValue
    @Column(name = "idjugador")
    private int idjugador;

    @Column(name = "dni")
    private int dni;

    @Column(name = "idclub")
    private int idclub;

    @Column(name = "entregado",nullable=true)
    private boolean entregado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanac",nullable=true)
    private Date fechanac;

   @Column(name = "foto")
    private String foto;

    public int getIdJugador() {
        return idjugador;
    }

    public void setIdJugador(int id) {
        this.idjugador = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }



    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

   public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
