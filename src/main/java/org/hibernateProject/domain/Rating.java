package org.hibernateProject.domain;

public enum Rating {
    G("G"),
    PG("PG"),
    R("R"),
    NC17("NC-17"),
    PG13("PG-13");

    private final String value;

    public String getValue() {
        return value;
    }

    Rating(String value) {
        this.value = value;
    }
}
