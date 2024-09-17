package dev.ua.ikeepcalm.microservice.database;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Toast, Long> {

}
