package dev.ua.ikeepcalm.microservice.database;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToastWrapper {

    @JsonProperty("header")
    private String header;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("message")
    private String content;

}
