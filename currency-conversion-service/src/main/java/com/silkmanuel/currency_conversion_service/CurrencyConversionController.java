package com.silkmanuel.currency_conversion_service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;

    public CurrencyConversionController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversationBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversationBean currencyConversationBean = new CurrencyConversationBean(
            10001L, 
            from, 
            to, 
            BigDecimal.ONE, 
            quantity, 
            quantity 
        );
        currencyConversationBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return currencyConversationBean;
    }
}
