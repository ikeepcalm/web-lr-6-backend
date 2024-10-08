package dev.ua.ikeepcalm.microservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.ua.ikeepcalm.microservice.database.Service;
import dev.ua.ikeepcalm.microservice.database.Toast;
import dev.ua.ikeepcalm.microservice.database.ToastWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/api/ping")
    public ResponseEntity<String> pingController() {
        return ResponseEntity.ok("Hello from Railway + Spring!");
    }

    @PostMapping("/api/saveSingle")
    public ResponseEntity<String> saveSingle(@RequestBody String content) {
        ToastWrapper toast = parseToast(content);

        if (toast == null) {
            return ResponseEntity.badRequest().body("Invalid toast format!");
        }

        service.save(new Toast(toast));

        return ResponseEntity.ok("Single toast saved!");
    }

    @PostMapping("/api/saveMultiple")
    public ResponseEntity<String> saveMultiple(@RequestBody String content) {
        try {
            List<ToastWrapper> toasts = parseToasts(content);
            if (toasts != null) {
                for (ToastWrapper toast : toasts) {
                    service.save(new Toast(toast));
                }
            }
        } catch (Exception e) {
            log.error("Invalid toasts format: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Invalid toasts format!");
        }

        return ResponseEntity.ok("Multiple toasts saved!");
    }

    @DeleteMapping("/api/deleteAll")
    public ResponseEntity<String> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok("All toasts deleted!");
    }

    @GetMapping("/api/getAll")
    public ResponseEntity<Iterable<Toast>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    private ToastWrapper parseToast(String content) {
        JsonMapper mapper = new JsonMapper();
        try {
            return mapper.readValue(content, ToastWrapper.class);
        } catch (Exception e) {
            return null;
        }
    }

    private List<ToastWrapper> parseToasts(String content) {
        JsonMapper mapper = new JsonMapper();
        try {
            return mapper.readValue(content, new TypeReference<List<ToastWrapper>>() {
            });
        } catch (Exception e) {
            return null;
        }
    }

}
