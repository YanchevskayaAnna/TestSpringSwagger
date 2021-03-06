package com.epam.producing.testProject.model;

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
//@EqualsAndHashCode(exclude = "")
@Table(name = "employees")
public class Employee {

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
    private String name;

    @Column
    private String role;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "employee_addresses",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "address_id") })
    private Set<Address> addresses = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
