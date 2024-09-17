package dev.ua.ikeepcalm.microservice.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Toast {

    @Id
    private Long id;

    @Column
    private String header;

    @Column
    private Date date;

    @Column
    private String content;
}
