package pe.edu.i202223807.cl2_mvc_armasdiego.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActorPK {
    private Integer actorId;
    private Integer filmId;
}
