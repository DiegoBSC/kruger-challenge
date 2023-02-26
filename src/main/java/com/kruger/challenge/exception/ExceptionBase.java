package com.kruger.challenge.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionBase {
    private String message;
}
