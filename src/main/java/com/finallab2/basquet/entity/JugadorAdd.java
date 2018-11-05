package com.finallab2.basquet.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by WIZERWOLF on 10/7/2017.
 */
public class JugadorAdd {

    private int idjugador;

    private int dni;

    private int idclub;


    private int idclubpase=0;


    private boolean entregado=false;


    private String nombre;

    private String apellido;


    private String pase="";


    private String fechanac="";

    //url de la foto
    private String foto="";

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
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

    public int getIdclubpase() {
        return idclubpase;
    }

    public void setIdclubpase(int idclubpase) {
        this.idclubpase = idclubpase;
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

    public String getPase() {
        return pase;
    }

    public void setPase(String pase) {
        this.pase = pase;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
