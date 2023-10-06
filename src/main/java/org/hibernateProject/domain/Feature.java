package org.hibernateProject.domain;

import static java.util.Objects.isNull;

public enum Feature {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    Deleted_Scenes("Deleted Scenes"),
    Behind_the_Scenes("Behind the Scenes");

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Feature getFeatureByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }

        Feature[] features = Feature.values();
        for (Feature feature : features) {
            if (feature.value.equals(value)) {
                return feature;
            }
        }

        return null;
    }
}
