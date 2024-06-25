package ar.frba.utn.sharksales.accenture2024equipo03inventario.Controller;


import java.util.List;
import java.util.Optional;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.MovimientoStock;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.repositories.MovimientoStockRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MovimientoStock")
public class MovimientoStockController {

  @Autowired
  MovimientoStockRepositorio movimientoStockRepositorio;

  @PostMapping
  public ResponseEntity<MovimientoStock> addMovimientoStock(@RequestBody MovimientoStock movimientoStock) {
    MovimientoStock movimientoStockGuardado = movimientoStockRepositorio.save(movimientoStock);
    return ResponseEntity.ok(movimientoStockGuardado);
  }

  @GetMapping
  public ResponseEntity<List<MovimientoStock>> getAllMovimientoStock() {
    List<MovimientoStock> movimientoStock = movimientoStockRepositorio.findAll();
    return ResponseEntity.ok(movimientoStock);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MovimientoStock> getMovimientoStockById(@PathVariable Long id) {
    Optional<MovimientoStock> movimientoStock = movimientoStockRepositorio.findById(id);
    if (movimientoStock.isPresent()) {
      return ResponseEntity.ok(movimientoStock.get());
    }
    else{
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping
  public ResponseEntity<MovimientoStock> updateMovimientoStock(@RequestBody MovimientoStock movimientoStock) {
    MovimientoStock movimientoStockGuardado = movimientoStockRepositorio.save(movimientoStock);
    return ResponseEntity.ok(movimientoStock);
  }

}
