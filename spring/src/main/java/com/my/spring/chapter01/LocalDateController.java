package com.my.spring.chapter01;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalDateController {
   public String get(@DateTimeFormat(iso=ISO.DATE) LocalDate localDate) {
       return localDate.toString();
   }
}
