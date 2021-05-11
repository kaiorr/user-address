package br.com.kaiorr.useraddress.services.exceptions;

public class ArtefactNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ArtefactNotFoundException(String msg) {
        super(msg);
    }
}
