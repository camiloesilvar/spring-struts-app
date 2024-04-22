package org.csr.back.model.usager.service;

import java.util.Collection;

import org.csr.back.model.usager.dto.UsagerDto;

public interface UsagerService {
	public void addUsager(UsagerDto usager);
	public UsagerDto getUsagerById(Long idUsager);
	public Collection<UsagerDto> listeUsagers();
}
