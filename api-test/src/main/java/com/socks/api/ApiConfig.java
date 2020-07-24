package com.socks.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ApiConfig extends Config {

    String baseUrl();
    String locale();
    boolean logging();
}