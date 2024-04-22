package org.csr.back.model.ville.dao;

import java.util.List;

import org.csr.back.model.ville.entity.Ville;

public interface VilleDao {
	List<Ville> findAll();
}
