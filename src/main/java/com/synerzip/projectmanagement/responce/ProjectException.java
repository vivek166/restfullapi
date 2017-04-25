package com.synerzip.projectmanagement.responce;

import java.io.Serializable;

public class ProjectException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	public ProjectException() {
		super();
	}
	public ProjectException(String msg) {
		super(msg);
	}
}
