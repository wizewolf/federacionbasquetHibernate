package com.finallab2.basquet.service;

import com.finallab2.basquet.dao.IJugadorDAO;
import com.finallab2.basquet.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
public class JugadorService implements IJugadorService {
    @Autowired
    private IJugadorDAO jugadorDAO;

    @Override
    public Jugador getJugadorById(int jugadorId) throws Exception{
        Jugador obj = jugadorDAO.getJugadorById(jugadorId);
        return obj;
    }

    @Override
    public List<Jugador> getAllJugadores() {
        return jugadorDAO.getAllJugadores();
    }

    @Override
    public synchronized boolean addJugador(Jugador jugador) {
        if (jugadorDAO.jugadorExists(jugador.getDni())) {
            return false;
        } else {
           /* Jugador jg = new Jugador();
            jg.setNombre(jugadoradd.getNombre());
            jg.setApellido(jugadoradd.getApellido());
            jg.setIdclub(jugadoradd.getIdclub());
            jg.setIdclubpase(jugadoradd.getIdclubpase());
            jg.setPase(jugadoradd.getPase());
            if (!jugadoradd.getFechanac().equals("")) {
                jg.setFechanac(new Date(jugadoradd.getFechanac()));
            }

            jg.setDni(jugadoradd.getDni());
            if (!jugadoradd.getFoto().equals("")) {
                URL url = new URL(jugadoradd.getFoto());
                Image foto = ImageIO.read(url);
                jg.setFoto(imagenABlob(foto));
            }*/

            jugadorDAO.addJugador(jugador);
            return true;
        }
    }

    @Override
    public void updateJugador(Jugador jugador) {
        jugadorDAO.updateJugador(jugador);
    }

    @Override
    public void deleteJugador(int jugadorId) {
        jugadorDAO.deleteJugador(jugadorId);
    }

    //metodos para combertir en awt.image en blob y viseversa
    public BufferedImage obtenerImagen(Blob blob) throws IOException, SQLException {
        byte[] data = blob.getBytes(1, (int) blob.length());
        return ImageIO.read(new ByteArrayInputStream(data));
    }

    public Blob imagenABlob(Image image) throws IOException, SQLException {
        //transforma la imagen en un BufferedImage para poder convertilo a blob
        BufferedImage buffered = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.SCALE_SMOOTH);
        buffered.getGraphics().drawImage(image, 0, 0, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(buffered, "jpg", baos);
        byte[] imageInByte = baos.toByteArray();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
        blob.setBytes(1, imageInByte);
        return blob;
    }
}
