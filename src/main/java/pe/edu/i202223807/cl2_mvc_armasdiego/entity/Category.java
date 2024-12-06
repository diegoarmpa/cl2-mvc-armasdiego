package pe.edu.i202223807.cl2_mvc_armasdiego.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film_category")
public class Category {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private CategoryPK categoryPK;
    private Date lastUpdate;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    @MapsId ("filmId")
    private Film film;

}
