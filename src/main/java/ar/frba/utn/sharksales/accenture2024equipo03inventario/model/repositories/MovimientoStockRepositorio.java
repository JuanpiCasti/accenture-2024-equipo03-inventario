package ar.frba.utn.sharksales.accenture2024equipo03inventario.model.repositories;


import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepositorio extends JpaRepository<MovimientoStock,Long> {
}
