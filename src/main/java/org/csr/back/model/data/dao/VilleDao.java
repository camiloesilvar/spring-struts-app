package org.csr.back.model.data.dao;

import java.util.List;

import org.csr.back.model.data.entity.Ville;

public interface VilleDao {
	List<Ville> findAll();
}
