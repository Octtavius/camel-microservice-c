package com.microservices.processors;

import com.microservices.beans.CurrencyExchange;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyCurrencyExchangeProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Logger loger = LoggerFactory.getLogger(this.getClass());
        CurrencyExchange currencyExchange = exchange.getIn().getBody(CurrencyExchange.class);

        loger.info("processing: \n" + currencyExchange.toString());
    }
}
