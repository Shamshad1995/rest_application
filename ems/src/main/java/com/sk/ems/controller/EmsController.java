package com.sk.ems.controller;

import com.sk.ems.constant.GlobalConstant;
import com.sk.ems.service.EmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmsController.class);
    private static final String REQUEST_MAPPING = "/emsData";
    private final EmsService emsService;

    public EmsController(EmsService emsService) {
        this.emsService = emsService;
    }

    @PostMapping(path = REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addData(@RequestBody String requestSData) {
        LOGGER.info("starting addData() in EmsController with the requestSData ::" + requestSData);
        String saveStatus;
        if (requestSData != null && !requestSData.trim().isBlank())
            saveStatus = emsService.addData();
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalConstant.BAD_REQUEST);
        if (saveStatus.equals(GlobalConstant.SUCCESS_STRING)) {
            LOGGER.info("Ending addData() in EmsController with the Response ::" + saveStatus);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(saveStatus);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GlobalConstant.INTERNAL_SERVER_ERROR);
    }
}
