package org.csr.front.web.controller.struts;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.csr.front.web.model.SessionObject;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("spring-struts")
@Namespace("/strutsapp/strutsaction/tile")
@Results({ 
	@Result(name = StrutsAppAction.GET_ACTION, location = "/WEB-INF/jsp/struts_page.jsp"),
	@Result(name = StrutsAppAction.GET_TILE_ACTION, type = "tiles", location = "/tiles/struts/straction/getaction"),
	@Result(name = StrutsAppAction.GET_FORM_HTM_ACTION, type = "tiles", location = "/tiles/struts/straction/getFormHtmlaction"),
	@Result(name = StrutsAppAction.GET_FORM_STR_ACTION, type = "tiles", location = "/tiles/struts/straction/getFormStrutsaction")
})
public class StrutsAppAction extends ActionSupport {

    private static final long serialVersionUID = -5324525816481241837L;

    public static final String GET_ACTION = "GET_ACTION";
    public static final String GET_TILE_ACTION = "GET_TILE_ACTION";
    public static final String GET_FORM_HTM_ACTION = "GET_FORM_HTM_ACTION";
    public static final String GET_FORM_STR_ACTION = "GET_FORM_STR_ACTION";

    static Logger logger = LogManager.getLogger(StrutsAppAction.class);

    // http://localhost:8080/spring-struts-app/strutsapp/strutsaction/tile/getTileAction.action
    @Action(value = "getTileAction")
    public String getTileAction() {
        HttpSession httpSession = ServletActionContext.getRequest().getSession();
        SessionObject sessionObject = (SessionObject) httpSession.getAttribute("sessionObj");
        if (sessionObject == null) {
            sessionObject = new SessionObject(httpSession.getId(), new Long(0), System.currentTimeMillis());
            httpSession.setAttribute("sessionObj", sessionObject);
        }
        return GET_TILE_ACTION;
    }
    
    @Action(value = "getFormStrutsAction")
    public String getFormStrutsAction() {
    	return GET_FORM_STR_ACTION;
    }
    
    @Action(value = "getFormHtmlAction")
    public String getFormHtmlAction() {
    	return GET_FORM_HTM_ACTION;
    }
    
    // http://localhost:8080/spring-struts-app/strutsapp/strutsaction/tile/getAction.action
    @Action(value = "getAction")
    public String getAction() {
        return GET_ACTION;
    }
    
    @Action(value = "sessionInvalidateAction")
    public String invalidateSession() {
    	HttpSession httpSession = ServletActionContext.getRequest().getSession();
    	httpSession.invalidate();
    	ServletActionContext.getRequest().getSession(true);
        return GET_TILE_ACTION;
    }
}
