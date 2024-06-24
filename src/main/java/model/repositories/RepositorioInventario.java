package model.repositories;

import java.util.List;
import model.producto.InventarioProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositorioInventario extends JpaRepository<InventarioProducto, Long> {

  List<InventarioProducto> findByProducto(String nombre);

}
