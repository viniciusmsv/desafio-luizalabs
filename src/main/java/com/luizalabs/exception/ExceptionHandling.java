package com.luizalabs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandling implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if(exception.getCause() instanceof BusinessException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(exception.getCause().getMessage())
                    .build();
        } else if(exception.getCause() instanceof NotFoundException){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(exception.getCause().getMessage())
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ops!!! Ocorreu um erro! =(")
                    .build();
        }
    }
}
