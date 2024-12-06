package pe.edu.i202223807.cl2_mvc_armasdiego.dto;

import java.util.Date;

public record FilmDetailDTO(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures,
                            Date lastUpdate) {
}
