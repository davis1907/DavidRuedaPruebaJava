package com.itehl.api.model;


import java.io.Serializable;

public class ResponseService<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String message;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    

    
}
