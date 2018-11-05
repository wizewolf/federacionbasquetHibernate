package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Carnet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CarnetDAO implements ICarnetDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Carnet getCarnetById(int carnetid) {
		return entityManager.find(Carnet.class, carnetid);
	}

	@Override
	public Carnet getCarnetByIdJugadorAnio(int idjugador, int anio) {
		String hql = "FROM Carnet as carnet WHERE carnet.aniodeseguro = ? and carnet.idjugador = ?";
		List<Carnet> carnets = entityManager.createQuery(hql).setParameter(1, anio)
				.setParameter(2, idjugador).getResultList();
		if (carnets.size()==1){
			return carnets.get(0);
		}else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carnet> getAllCarnet() {
		String hql = "FROM Carnet as carnet ORDER BY carnet.idcarnet";
		return (List<Carnet>) entityManager.createQuery(hql).getResultList();
	}
	@Override
	public void addCarnet(Carnet carnet) {
		entityManager.persist(carnet);
	}
	@Override
	public void updateCarnet(Carnet carnet) {
		Carnet carnetUpdate = getCarnetById(carnet.getIdcarnet());
		carnetUpdate.setgetAnioDeSeguro(carnet.getAnioDeSeguro());
		carnetUpdate.setIdjugador(carnet.getIdjugador());
		entityManager.flush();
	}
	@Override
	public void deleteCarnet(int carnetId) {
		entityManager.remove(getCarnetById(carnetId));
	}
	@Override
	public boolean carnetExists(int anio, int idjugador){
		String hql = "FROM Carnet as carnet WHERE carnet.aniodeseguro = ? and carnet.idjugador = ?";
		int count = entityManager.createQuery(hql).setParameter(1, anio)
				.setParameter(2, idjugador).getResultList().size();
		if (count >0 ){
			return true;
		}else{
			return false;

		}

	}

}
