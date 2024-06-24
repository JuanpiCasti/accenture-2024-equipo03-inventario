package model.repositories;


import model.producto.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepositorio extends JpaRepository<MovimientoStock,Long> {
}
