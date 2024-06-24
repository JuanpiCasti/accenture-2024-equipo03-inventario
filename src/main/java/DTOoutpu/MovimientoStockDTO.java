package DTOoutpu;

import model.producto.TipoMovimiento;
import java.time.LocalDateTime;

public class MovimientoStockDTO {
  private Long id;
  private LocalDateTime fecha;
  private int cantidad;
  private TipoMovimiento tipoMovimiento;

  // Getters y Setters (no mostrados para mayor claridad)
}