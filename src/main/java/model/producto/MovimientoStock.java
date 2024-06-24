package model.producto;

import Persistente.Persistente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MovimientoStock extends Persistente {
    @Column
    private LocalDateTime fecha;
    @Column
    private int cantidad;
    @Enumerated(EnumType.STRING)
    @Column
    private TipoMovimiento tipoMovimiento;

    public MovimientoStock(LocalDateTime fecha, int cantidad, TipoMovimiento tipoMovimiento) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;

    }
}
