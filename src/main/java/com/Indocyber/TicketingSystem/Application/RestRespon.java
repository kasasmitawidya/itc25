package com.Indocyber.TicketingSystem.Application;

import lombok.Data;

@Data
public class RestRespon<T> {
    private  final T data;
    private final String message;
    private  final String status;

}
