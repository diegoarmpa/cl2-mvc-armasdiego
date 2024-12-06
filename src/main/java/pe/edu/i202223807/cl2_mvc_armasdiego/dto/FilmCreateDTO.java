package pe.edu.i202223807.cl2_mvc_armasdiego.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record FilmCreateDTO(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures,
                            Integer languageId,
                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                            Date lastUpdate


) {
}
