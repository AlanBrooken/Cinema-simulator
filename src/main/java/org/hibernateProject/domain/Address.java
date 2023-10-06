package org.hibernateProject.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address", schema = "movie")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    @Column(nullable = false)
    private String address;
    @Column
    private String address2;
    @Column(nullable = false, length = 20)
    private String district;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(length = 20, nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
