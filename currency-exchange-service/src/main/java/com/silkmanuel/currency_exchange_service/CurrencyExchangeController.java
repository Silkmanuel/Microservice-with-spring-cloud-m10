package com.silkmanuel.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.opentelemetry.api.trace.Span;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        log.info("Trace atual: {}", Span.current().getSpanContext().getTraceId());
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
