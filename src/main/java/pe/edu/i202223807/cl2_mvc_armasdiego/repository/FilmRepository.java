package pe.edu.i202223807.cl2_mvc_armasdiego.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import pe.edu.i202223807.cl2_mvc_armasdiego.entity.Film;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    @Cacheable(value = "films")
    Iterable<Film> findAll();

    @CacheEvict(value = "films",allEntries = true)
    Film save(Film film);

    @CacheEvict(value = "films",allEntries = true)
    void deleteById(Integer id);

}
