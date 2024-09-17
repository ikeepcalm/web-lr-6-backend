package dev.ua.ikeepcalm.microservice.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Toast {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String header;

    @Column
    private Date date;

    @Column
    private String content;

    public Toast(ToastWrapper toast) {
        this.header = toast.getHeader();
        this.date = toast.getDate();
        this.content = toast.getContent();
    }

    public Toast() {

    }
}
