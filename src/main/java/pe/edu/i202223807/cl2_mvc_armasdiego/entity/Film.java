package pe.edu.i202223807.cl2_mvc_armasdiego.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    //Se elimina el languageId porque ya se esta referenciando
    //private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private Date lastUpdate;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "language_id")
    private Language languages;

    @ToString.Exclude
    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Actor> actor;

    @ToString.Exclude
    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Category>  categories;

    @ToString.Exclude
    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Inventory> inventory;
}
