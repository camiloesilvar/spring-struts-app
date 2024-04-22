package org.csr.back.model.usager.service.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.csr.back.model.usager.dto.UsagerDto;
import org.csr.back.model.usager.service.UsagerService;
import org.springframework.stereotype.Service;

@Service
public class UsagerServiceImpl implements UsagerService{

	private static Map<Long,UsagerDto> listeUsager = new HashMap<>();
	
	static {
		UsagerDto usager = new UsagerDto();
		usager.setId(100L);
		usager.setNom("nom:aaaaa");
		usager.setPrenom("prenom:aaaaa");
		usager.setAdresses(new ArrayList<>());
		usager.setContacts(new ArrayList<>());
		
		listeUsager.put(usager.getId(), usager);
		
		usager = new UsagerDto();
		usager.setId(200L);
		usager.setNom("nom:bbbbb");
		usager.setPrenom("prenom:bbbbb");
		usager.setAdresses(new ArrayList<>());
		usager.setContacts(new ArrayList<>());
		
		listeUsager.put(usager.getId(), usager);
		
		usager = new UsagerDto();
		usager.setId(300L);
		usager.setNom("nom:ccccc");
		usager.setPrenom("prenom:ccccc");
		usager.setAdresses(new ArrayList<>());
		usager.setContacts(new ArrayList<>());
		
		listeUsager.put(usager.getId(), usager);
	}

	public UsagerDto getUsagerById(Long id) {
		return listeUsager.get(id);
	}
	
	public void addUsager(UsagerDto usager) {
		listeUsager.put(usager.getId(), usager);
	}

	@Override
	public Collection<UsagerDto> listeUsagers() {
		return listeUsager.values();
	}
	
	
}
