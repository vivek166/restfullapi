package com.synerzip.projectmanagement.responce;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class RecordNotFoundException extends Exception implements
		ExceptionMapper<RecordNotFoundException> {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		super("No record found with given projectId !!");
	}

	public RecordNotFoundException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(RecordNotFoundException exception) {
		return Response.status(404).entity(exception.getMessage())
				.type("text/plain").build();
	}
}
