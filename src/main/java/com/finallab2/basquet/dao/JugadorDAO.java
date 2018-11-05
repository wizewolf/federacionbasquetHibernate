package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Jugador;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class JugadorDAO implements IJugadorDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Jugador getJugadorById(int jugadorId) {
		return entityManager.find(Jugador.class, jugadorId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> getAllJugadores() {
		String hql = "FROM Jugador as jugador ORDER BY jugador.idclub";
		return (List<Jugador>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addJugador(Jugador jugador) {
		entityManager.persist(jugador);
	}
	@Override
	public void updateJugador(Jugador jugador) {
		Jugador jugadorUpdate = getJugadorById(jugador.getIdJugador());
		jugadorUpdate.setNombre(jugador.getNombre());
		jugadorUpdate.setApellido(jugador.getApellido());
		jugadorUpdate.setDni(jugador.getDni());
		jugadorUpdate.setFechanac(jugador.getFechanac());
		jugadorUpdate.setEntregado(jugador.isEntregado());
		jugadorUpdate.setIdclub(jugador.getIdclub());
		//jugadorUpdate.setPase(jugador.getPase());
		//jugadorUpdate.setFoto(jugador.getFoto());
		entityManager.flush();
	}
	@Override
	public void deleteJugador(int jugadorId) {
		entityManager.remove(getJugadorById(jugadorId));
	}
	@Override
	public boolean jugadorExists(int dni) {
		String hql = "FROM Jugador as jugador WHERE jugador.dni = ?";
		int count = entityManager.createQuery(hql).setParameter(1, dni)
				.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public Jugador getDni(int dni) {
		String hql = "FROM Jugador as jugador WHERE jugador.dni = ?";
		List<Jugador> jugadors = entityManager.createQuery(hql).setParameter(1, dni)
				.getResultList();
		if (jugadors.size()==1){
			return jugadors.get(0);
		}else {
			return null;
		}
	}
}
