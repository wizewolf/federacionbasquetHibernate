package com.finallab2.basquet.entity;

import java.util.Date;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class CarnetView {
    private String nombreJ,apellidoJ,foto,nombreClub,direccionClub;
    private int dni;
    private Date fechanac;

    public String getNombreJ() {
        return nombreJ;
    }

    public void setNombreJ(String nombreJ) {
        this.nombreJ = nombreJ;
    }

    public String getApellidoJ() {
        return apellidoJ;
    }

    public void setApellidoJ(String apellidoJ) {
        this.apellidoJ = apellidoJ;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public String getDireccionClub() {
        return direccionClub;
    }

    public void setDireccionClub(String direccionClub) {
        this.direccionClub = direccionClub;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
}
