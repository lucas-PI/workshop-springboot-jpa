package com.educando.course.services.exception;

public class ResourceByNameNotFound extends RuntimeException{

    public ResourceByNameNotFound(String name){
        super("Resource not found. name: " + name);
    }
}
