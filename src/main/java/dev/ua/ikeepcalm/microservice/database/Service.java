package dev.ua.ikeepcalm.microservice.database;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void save(Toast toast) {
        repository.save(toast);
    }

    public Iterable<Toast> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Toast findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
