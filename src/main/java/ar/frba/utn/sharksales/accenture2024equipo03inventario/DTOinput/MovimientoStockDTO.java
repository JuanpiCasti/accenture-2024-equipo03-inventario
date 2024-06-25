package ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput;

import java.time.LocalDateTime;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto.TipoMovimiento;

public class MovimientoStockDTO {
  private LocalDateTime fecha;
  private int cantidad;
  private TipoMovimiento tipoMovimiento;


}