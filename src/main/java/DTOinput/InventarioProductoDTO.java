package DTOinput;

import DTOoutpu.MovimientoStockDTO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventarioProductoDTO {
  private Long productoId;
  private int stockActual;
  private int stockMaximo;
  private int stockMinimo;
  private List<MovimientoStockDTO> movimientosStockIds;
}