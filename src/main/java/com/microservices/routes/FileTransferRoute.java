package com.microservices.routes;

import com.microservices.beans.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class FileTransferRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .to("log:received-message-from-json-folder");
    }
}
