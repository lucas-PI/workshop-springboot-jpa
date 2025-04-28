package com.educando.course.Controllers.execptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@Data
@SuperBuilder
public class ExceptionDetails implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    protected Instant timestamp;
    protected Integer status;
    protected String error;
    protected String message;
    protected String path;

}
