package ar.frba.utn.sharksales.accenture2024equipo03inventario.Services;

import ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput.OperacionDTO;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.MovimientoStock;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.TipoMovimiento;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.repositories.MovimientoStockRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoStockService {

  @Autowired
  MovimientoStockRepositorio movimientoStockRepositorio;

  public MovimientoStock registrarMovimiento(OperacionDTO operacion) {
    TipoMovimiento tipoMovimiento = null;
    if(operacion.getCantidad()>0){tipoMovimiento = TipoMovimiento.INGRESO;}
    else {tipoMovimiento = TipoMovimiento.EGRESO;}
    MovimientoStock nuevoMovimiento = new MovimientoStock(operacion.getFecha(),operacion.getCantidad(), tipoMovimiento);
    return movimientoStockRepositorio.save(nuevoMovimiento);
  }
}
