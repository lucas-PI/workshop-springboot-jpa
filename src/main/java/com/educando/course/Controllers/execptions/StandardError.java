package com.educando.course.Controllers.execptions;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@Getter
@SuperBuilder
public class StandardError extends ExceptionDetails implements Serializable {

}
