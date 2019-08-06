package org.csr.front.struts.actions;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.csr.front.beans.SessionObject;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("spring-struts")
@Namespace("/strutsapp/strutsaction/tile")
@Results({ @Result(name = StrutsAppAction.GET_ACTION, type = "tiles", location = "/tiles/struts/straction/getaction") })
public class StrutsAppAction extends ActionSupport {

    private static final long serialVersionUID = -5324525816481241837L;

    public static final String GET_ACTION = "GET_ACTION";

    static Logger log = Logger.getLogger(StrutsAppAction.class);

    @Action(value = "getTileAction")
    public String get() {
        HttpSession httpSession = ServletActionContext.getRequest().getSession();
        SessionObject sessionObject = (SessionObject) httpSession.getAttribute("sessionObj");
        if (sessionObject == null) {
            sessionObject = new SessionObject(httpSession.getId(), new Long(0), System.currentTimeMillis());
            httpSession.setAttribute("sessionObj", sessionObject);
        }
        return GET_ACTION;
    }
}
