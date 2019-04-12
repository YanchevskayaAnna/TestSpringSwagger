package com.epam.producing.testProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data

@Table(name = "addresses")
@EqualsAndHashCode()
public class Address {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house_number;

    @Column
    private String flat_number;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "addresses")
    private Set<Employee> employees = new HashSet<>();

    public Address(String city, String street, String house_number, String flat_number) {
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.flat_number = flat_number;
    }

    public Address() {
    }

}
