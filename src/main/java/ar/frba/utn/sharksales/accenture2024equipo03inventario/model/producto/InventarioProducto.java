package ar.frba.utn.sharksales.accenture2024equipo03inventario.model.producto;

import ar.frba.utn.sharksales.accenture2024equipo03inventario.Persistente.Persistente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class InventarioProducto extends Persistente{
  @Column
  private Long productoid;
  @Column
  private int stockActual;
  @Column
  private int stockMaximo;
  @Column
  private int stockMinimo;

  @OneToMany(cascade = jakarta.persistence.CascadeType.ALL, fetch = jakarta.persistence.FetchType.LAZY)
  @JoinColumn(name = "inventario_id")
  private List<MovimientoStock> movimientosStock;

  public InventarioProducto(Long producto, int stockMaximo, int stockMinimo, int StockActual) {
    this.productoid = producto;
    this.stockMaximo = stockMaximo;
    this.stockMinimo = stockMinimo;
    this.movimientosStock = new ArrayList<>();
    this.stockActual = StockActual;

  }

  public Boolean hayEscasez(){
    return stockActual<stockMinimo;
  }
}
