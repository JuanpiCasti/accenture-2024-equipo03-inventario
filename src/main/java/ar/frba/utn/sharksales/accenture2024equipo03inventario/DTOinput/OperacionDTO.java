package ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;



@Data
public class OperacionDTO {
  private LocalDateTime fecha;
  private Long productoid;
  private int cantidad;
}
