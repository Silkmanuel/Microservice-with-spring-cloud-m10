package com.silkmanuel.limits_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silkmanuel.limits_service.bean.Configuration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Configuration retrieveLimitsFromConfigurations() {
        return new Configuration(configuration.getMinimum(), configuration.getMaximum());
    }
}