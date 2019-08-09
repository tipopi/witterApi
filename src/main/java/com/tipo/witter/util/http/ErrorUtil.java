package com.tipo.witter.util.http;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 7/31/20191:20 PM
 */
public class ErrorUtil {


    public static List<String> getErrorList(BindingResult result) {
            List<String> erros = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                erros.add(error.getDefaultMessage());
            }
            return erros;
    }
}