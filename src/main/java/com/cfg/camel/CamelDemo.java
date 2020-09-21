package com.cfg.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelDemo {

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
    }
}
