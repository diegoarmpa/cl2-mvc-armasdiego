package pe.edu.i202223807.cl2_mvc_armasdiego.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmCreateDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDetailDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.entity.Film;
import pe.edu.i202223807.cl2_mvc_armasdiego.repository.FilmRepository;
import pe.edu.i202223807.cl2_mvc_armasdiego.repository.LanguageRepository;
import pe.edu.i202223807.cl2_mvc_armasdiego.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDTO> findAllFilms() {
        List<FilmDTO> films = new ArrayList<FilmDTO>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDTO filmDTO = new FilmDTO(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguages().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDTO);
        });
        return films;
    }

    @Override
    public FilmDetailDTO findDetailById(Integer id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                film -> new FilmDetailDTO(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())
        ).orElse(null);

    }

    @Override
    public Boolean updateFilm(FilmDetailDTO filmDetailDTO) {
        Optional<Film> optional = filmRepository.findById(filmDetailDTO.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDTO.title());
                    film.setDescription(filmDetailDTO.description());
                    film.setReleaseYear(filmDetailDTO.releaseYear());
                    film.setRentalDuration(filmDetailDTO.rentalDuration());
                    film.setRentalRate(filmDetailDTO.rentalRate());
                    film.setLength(filmDetailDTO.length());
                    film.setReplacementCost(filmDetailDTO.replacementCost());
                    film.setRating(filmDetailDTO.rating());
                    film.setSpecialFeatures(filmDetailDTO.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean createFilm(FilmCreateDTO filmCreateDTO) {
        Film film = new Film();
        film.setTitle(filmCreateDTO.title());
        film.setDescription(filmCreateDTO.description());
        film.setReleaseYear(filmCreateDTO.releaseYear());
        film.setRentalDuration(filmCreateDTO.rentalDuration());
        film.setRentalRate(filmCreateDTO.rentalRate());
        film.setLength(filmCreateDTO.length());
        film.setReplacementCost(filmCreateDTO.replacementCost());
        film.setRating(filmCreateDTO.rating());
        film.setSpecialFeatures(filmCreateDTO.specialFeatures());
        film.setLanguages(languageRepository.findById(filmCreateDTO.languageId()).orElse(null));
        film.setLastUpdate(new Date());
        filmRepository.save(film);
        return true;
    }

    @Override
    public Boolean deleteFilm(Integer id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                film -> {
                    filmRepository.delete(film);
                    return true;
                }
        ).orElse(false);
    }


}
