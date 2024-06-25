package ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput;

import java.time.LocalDateTime;
import lombok.Getter;



@Getter
public class OperacionDTO {
  private LocalDateTime fecha;
  private Long productoid;
  private int cantidad;
}
