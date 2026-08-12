package com.silkmanuel.currency_conversion_service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeServiceFallback implements CurrencyExchangeServiceProxy {

    @Override
    public CurrencyConversationBean retrieveExchangeValue(String from, String to) {
        CurrencyConversationBean response = new CurrencyConversationBean();
        response.setFrom(from);
        response.setTo(to);
        response.setConversionMultiple(BigDecimal.ZERO);
        response.setPort(0);
        response.setMessage("Currency Exchange Service is unavailable");
        return response;
    }
}
