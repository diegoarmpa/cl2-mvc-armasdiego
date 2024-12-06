package pe.edu.i202223807.cl2_mvc_armasdiego.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film_actor")
public class Actor {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ActorPK actorPK;
    private Date lastUpdate;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @MapsId("filmId")
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

}
