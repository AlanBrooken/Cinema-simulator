package org.hibernateProject.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "staff", schema = "movie")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private Blob picture;
    @Column
    private String email;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false)
    private boolean active;
    @Column(length = 16, nullable = false)
    private String username;
    @Column
    private String password;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "staff")
    private List<Payment> payments;

    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;

}
