package com.luis.clientegreeting.domain;

public class Greeting {

    protected String content;

    protected Greeting() {
        this.content = "Hello!";
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
