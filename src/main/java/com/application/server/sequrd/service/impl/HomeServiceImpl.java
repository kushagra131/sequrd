package com.application.server.sequrd.service.impl;

import com.application.server.sequrd.domain.record.HomeDetails;
import com.application.server.sequrd.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public HomeDetails getHomeDetails() {
        return new HomeDetails(UUID.randomUUID().toString(), "SEQURD.io");
    }
}
