package com.passenger.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.transform.sax.SAXResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{
    private String message;
}
