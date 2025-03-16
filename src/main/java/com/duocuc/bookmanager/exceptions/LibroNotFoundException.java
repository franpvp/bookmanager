package com.duocuc.bookmanager.exceptions;

public class LibroNotFoundException extends RuntimeException{
    public LibroNotFoundException(String mensaje) {
        super(mensaje);
    }
}
