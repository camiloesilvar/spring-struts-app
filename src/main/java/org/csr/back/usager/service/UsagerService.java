package org.csr.back.usager.service;

import java.util.Collection;

import org.csr.back.usager.dto.UsagerDto;

public interface UsagerService {
	public void addUsager(UsagerDto usager);
	public UsagerDto getUsagerById(Long idUsager);
	public Collection<UsagerDto> listeUsagers();
}
