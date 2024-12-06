package pe.edu.i202223807.cl2_mvc_armasdiego.service;

import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmCreateDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDTO;
import pe.edu.i202223807.cl2_mvc_armasdiego.dto.FilmDetailDTO;

import java.util.List;

public interface MaintenanceService {

    List<FilmDTO> findAllFilms();

    FilmDetailDTO findDetailById(Integer id);

    Boolean updateFilm(FilmDetailDTO filmDetailDTO);

    Boolean createFilm(FilmCreateDTO filmCreateDTO);

    Boolean deleteFilm(Integer id);

}
