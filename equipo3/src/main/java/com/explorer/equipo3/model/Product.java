package com.explorer.equipo3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "product")
    private Set<Image> images;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;
    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    public Product(String name, Category category, Location location, Set<Image> images, User user) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.images = images;
        this.user = user;
    }
}
