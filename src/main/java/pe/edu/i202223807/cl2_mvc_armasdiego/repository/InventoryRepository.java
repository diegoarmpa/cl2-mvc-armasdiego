package pe.edu.i202223807.cl2_mvc_armasdiego.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202223807.cl2_mvc_armasdiego.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
