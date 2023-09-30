package com.sk.ems.controller;

import com.sk.ems.service.EmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmsController.class);
    private final EmsService emsService;

    public EmsController(EmsService emsService) {
        this.emsService = emsService;
    }

    @PostMapping(path = "/emsData")
    public ResponseEntity<?> addData(@RequestBody String requestSData) {
        LOGGER.info("starting getData() in EmsController with the requestSData ::" + requestSData);
        String status;
        if (requestSData != null && !requestSData.trim().isBlank()) {
            status = emsService.addData();
        } else {
            return ResponseEntity.badRequest().body("Bad Request");
        }
        if (status.equals("success")) {
            LOGGER.info("Ending getData() in EmsController with the Response ::" + status);
            return ResponseEntity.badRequest().body(status);
        }
        LOGGER.info("Ending getData() in EmsController with the Response ::");
        return ResponseEntity.badRequest().body("Internal Sever Error");
    }
}
