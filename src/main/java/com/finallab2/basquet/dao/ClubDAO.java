package com.finallab2.basquet.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finallab2.basquet.entity.Club;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ClubDAO implements IClubDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Club getClubById(int clubId) {
		return entityManager.find(Club.class, clubId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Club> getAllClubs() {
		String hql = "FROM Club as club ORDER BY club.idclub";
		return (List<Club>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addClub(Club club) {
		entityManager.persist(club);
	}
	@Override
	public void updateClub(Club club) {
		Club clubUpdate = getClubById(club.getIdClub());
		clubUpdate.setNombre(club.getNombre());
		clubUpdate.setDireccion(club.getDireccion());
		entityManager.flush();
	}
	@Override
	public void deleteClub(int clubId) {
		entityManager.remove(getClubById(clubId));
	}
	@Override
	public boolean clubExists(String nombre, String direccion) {
		String hql = "FROM Club as club WHERE club.nombre = ? and club.direccion = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nombre)
				.setParameter(2, direccion).getResultList().size();
		return count > 0 ? true : false;
	}
}
