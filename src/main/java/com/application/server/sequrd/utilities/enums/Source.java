package com.application.server.sequrd.utilities.enums;

public enum Source {

    POSTMAN("Postman"),
    WEB("Web"),
    ANONYMOUS("Anonymous");

    public final String value;

    Source(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
