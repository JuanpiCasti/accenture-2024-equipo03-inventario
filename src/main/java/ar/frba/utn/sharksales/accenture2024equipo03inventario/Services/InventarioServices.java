package ar.frba.utn.sharksales.accenture2024equipo03inventario.Services;

import ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput.OperacionDTO;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.InventarioProducto;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.repositories.RepositorioInventario;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ.Sender;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventarioServices {

  @Autowired
  RepositorioInventario repositorioInventario;

  @Autowired
  MovimientoStockService movimientoStockService;

  @Autowired
  private Sender sender;

  public ResponseEntity<OperacionDTO> registrarOperacion(OperacionDTO operacion) {
    Optional<InventarioProducto> inventarioProducto = repositorioInventario.findByProductoid(operacion.getProductoid());
    if(inventarioProducto.isPresent()){
      InventarioProducto producto = inventarioProducto.get();
      producto.setStockActual(producto.getStockActual() + operacion.getCantidad());
      producto.getMovimientosStock().add(movimientoStockService.registrarMovimiento(operacion));
      repositorioInventario.save(producto);
      this.stockCheck(producto, operacion);
      return ResponseEntity.ok(operacion);
    }
    else return ResponseEntity.notFound().build();
  }


  public void stockCheck(InventarioProducto inventarioProducto,OperacionDTO operacion){
    if(inventarioProducto.getStockActual() < inventarioProducto.getStockMinimo()){
      sender.sendMessage(operacion);}
  }
}
