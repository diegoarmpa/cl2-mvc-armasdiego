package pe.edu.i202223807.cl2_mvc_armasdiego.dto;

public record FilmDTO(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate) {
}
