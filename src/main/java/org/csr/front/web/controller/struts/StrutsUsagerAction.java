package org.csr.front.web.controller.struts;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.csr.back.usager.dto.UsagerDto;
import org.csr.back.usager.service.UsagerService;
import org.csr.front.web.view.usager.FormulaireUsager;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("spring-struts")
@Namespace("/usager")
@Results({ 
	@Result(name = StrutsUsagerAction.FORMULAIRE_USAGER, type = "tiles", location = "/tiles/usager/formulaireusager"),
	@Result(name = StrutsUsagerAction.LISTE_USAGER, type = "tiles", location = "/tiles/usager/listeusager")
})
public class StrutsUsagerAction extends ActionSupport {

	private static final long serialVersionUID = -7106462656571596497L;
	
	public static final String GET_USAGER = "GET_USAGER";
	public static final String CREATE_USAGER = "CREATE_USAGER";
	public static final String FORMULAIRE_USAGER = "FORMULAIRE_USAGER";
	public static final String LISTE_USAGER = "LISTE_USAGER";
	
	
	private FormulaireUsager usager;
	private Collection<UsagerDto> listUsagers;
	
	@Autowired
	private UsagerService usagerService;
	
	@Action(value = "create")
    public String createUsager() {
		
		return FORMULAIRE_USAGER;
	}
	
	@Action(value = "get")
    public String getUsager() {
		
		return FORMULAIRE_USAGER;
	}

	@Action(value = "liste")
    public String listeUsager() {
		listUsagers = usagerService.listeUsagers();
		return LISTE_USAGER;
	}

	public Collection<UsagerDto> getListUsagers() {
		return listUsagers;
	}

	public void setListUsagers(Collection<UsagerDto> listUsagers) {
		this.listUsagers = listUsagers;
	}

	public void setUsager(FormulaireUsager usager) {
		this.usager = usager;
	}
	
	
}
