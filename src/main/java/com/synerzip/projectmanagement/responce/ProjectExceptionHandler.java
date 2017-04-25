package com.synerzip.projectmanagement.responce;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;


public final class  ProjectExceptionHandler implements ExceptionMapper<ProjectException> {

	@Override
	public Response toResponse(final ProjectException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
	}

}
