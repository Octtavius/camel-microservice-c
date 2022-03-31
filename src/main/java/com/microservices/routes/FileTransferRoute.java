package com.microservices.routes;

import com.microservices.beans.CurrencyExchange;
import com.microservices.processors.MyCurrencyExchangeProcessor;
import com.microservices.transformers.MyCurrencyExchangeTransformer;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileTransferRoute extends RouteBuilder {
    @Autowired
    MyCurrencyExchangeProcessor currencyExchangeProcessor;

    @Autowired
    MyCurrencyExchangeTransformer myCurrencyExchangeTransformer;

    @Override
    public void configure() throws Exception {


        from("file:files/json")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(myCurrencyExchangeTransformer)
                .process(currencyExchangeProcessor)
                .to("log:received-message-from-json-folder");

        from("file:files/xml")
                .unmarshal().jacksonXml(CurrencyExchange.class)
                .log("${body}")
                .process(currencyExchangeProcessor)
//                .to("log:received-xml-file");
                .to("activemq:my-activemq-xml");
    }
}
