package com.rodenbostel.temperature.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.OK;

/**
 * Created by justinrodenbostel on 5/18/17.
 */
@RestController
public class HealthCheckService {

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public ResponseEntity healthCheck() {
        return new ResponseEntity(OK);
    }
}
