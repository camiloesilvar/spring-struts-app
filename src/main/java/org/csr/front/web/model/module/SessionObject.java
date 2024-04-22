package org.csr.front.web.model.module;

import java.io.Serializable;

public class SessionObject implements Serializable {

    private static final long serialVersionUID = -7492701973434970836L;

    private String attribute;
    private Long number;
    private long index;

    public SessionObject(String attribute, Long number, long index) {
        super();
        this.attribute = attribute;
        this.number = number;
        this.index = index;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

	@Override
	public String toString() {
		return "SessionObject [attribute=" + attribute + ", number=" + number + ", index=" + index + "]";
	}

}
