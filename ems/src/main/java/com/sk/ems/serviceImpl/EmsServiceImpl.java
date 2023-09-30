package com.sk.ems.serviceImpl;

import com.sk.ems.service.EmsService;
import org.springframework.stereotype.Service;

@Service
public class EmsServiceImpl implements EmsService {
    @Override
    public String  addData() {
    return "success";
    }
}
