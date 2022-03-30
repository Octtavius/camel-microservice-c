package com.microservices.transformers;

import com.microservices.beans.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MyCurrencyExchangeTransformer {
    Logger log = LoggerFactory.getLogger(CurrencyExchange.class);

    public void tranformMessage(CurrencyExchange myCurrencyExchange) {
        myCurrencyExchange.setConversionMultiple(
                myCurrencyExchange.getConversionMultiple()
                        .multiply(BigDecimal.TEN)
        );

        log.info("Modified the received currencyExchange to {}", myCurrencyExchange.getConversionMultiple() );
    }
}
