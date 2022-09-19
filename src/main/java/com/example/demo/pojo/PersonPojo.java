package com.example.demo.pojo;

public class PersonPojo {
    private String aaa;
    private String bbb;

    public static void main(String[] args) {
        PersonPojo personPojo = new PersonPojo().setAaa("111").setBbb("222");
    }

    public String getAaa() {
        return aaa;
    }

    public PersonPojo setAaa(String aaa) {
        this.aaa = aaa;
        return this;
    }

    public String getBbb() {
        return bbb;
    }

    public PersonPojo setBbb(String bbb) {
        this.bbb = bbb;
        return this;
    }
}
