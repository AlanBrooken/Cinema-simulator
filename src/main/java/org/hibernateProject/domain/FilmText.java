package org.hibernateProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Integer id;

    @Column
    private String title;
    @Column
    private String description;
    @OneToOne
    private Film film;

}
