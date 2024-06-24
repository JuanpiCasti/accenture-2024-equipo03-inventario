package Controller;


import java.util.List;
import java.util.Optional;
import model.producto.InventarioProducto;
import model.repositories.RepositorioInventario;
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
@RequestMapping("/inventario")
public class InventarioController {
  @Autowired
  private RepositorioInventario repositorioInventario;

  @PostMapping
  public ResponseEntity<InventarioProducto> crearInventario(@RequestBody InventarioProducto inventarioProducto) {
    InventarioProducto inventarioProducto1 = repositorioInventario.save(inventarioProducto);
    return ResponseEntity.ok(inventarioProducto1);
  }

  @GetMapping
  public ResponseEntity<List<InventarioProducto>> listarInventario() {
    List<InventarioProducto> inventarioProducto = repositorioInventario.findAll();
    return ResponseEntity.ok(inventarioProducto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<InventarioProducto> buscarInventarioPorId(@PathVariable Long id) {
    Optional<InventarioProducto> inventarioProducto = repositorioInventario.findById(id);
    if (inventarioProducto.isPresent()) {
      return ResponseEntity.ok(inventarioProducto.get());
    }
    else {
      return ResponseEntity.notFound().build();
    }
  }

 @PutMapping
 public ResponseEntity<InventarioProducto> modificarInventario(@RequestBody InventarioProducto inventarioProducto) {
    InventarioProducto inventarioProducto1 = repositorioInventario.save(inventarioProducto);
    return ResponseEntity.ok(inventarioProducto1);
 }




}