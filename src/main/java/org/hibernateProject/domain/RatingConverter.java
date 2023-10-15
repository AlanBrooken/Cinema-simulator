package org.hibernateProject.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbDate) {
        Rating[] values = Rating.values();
        for (Rating rating : values) {
            if (rating.getValue().equals(dbDate)) {
                return rating;
            }
        }
        return null;
    }
}
