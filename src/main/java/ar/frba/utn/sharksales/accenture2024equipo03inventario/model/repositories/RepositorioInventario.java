package ar.frba.utn.sharksales.accenture2024equipo03inventario.model.repositories;

import java.util.List;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.InventarioProducto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepositorioInventario extends JpaRepository<InventarioProducto, Long> {

public Optional<InventarioProducto> findByProductoid(Long productoid);
}
