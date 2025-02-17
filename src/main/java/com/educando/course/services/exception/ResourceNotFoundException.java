package com.educando.course.services.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found id. id" + id);
    }
}
