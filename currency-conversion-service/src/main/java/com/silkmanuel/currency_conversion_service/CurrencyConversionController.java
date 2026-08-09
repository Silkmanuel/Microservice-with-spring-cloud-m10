package com.silkmanuel.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;

    public CurrencyConversionController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversationBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversationBean> responseEntity = new RestTemplate().getForEntity(
            "http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
            CurrencyConversationBean.class, 
            uriVariables
        );
        CurrencyConversationBean response = responseEntity.getBody();
        CurrencyConversationBean currencyConversationBean = new CurrencyConversationBean(
            response.getId(),
            from,
            to,
            response.getConversionMultiple(),
            quantity,
            quantity.multiply(response.getConversionMultiple())
        );
        currencyConversationBean.setPort(response.getPort());
        return currencyConversationBean;
    }
}
