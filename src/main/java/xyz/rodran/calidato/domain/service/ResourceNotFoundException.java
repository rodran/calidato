package xyz.rodran.calidato.domain.service;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String name, Long id) {
        super(name + " not found with id: " + id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
