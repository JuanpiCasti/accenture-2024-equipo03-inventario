package ar.frba.utn.sharksales.accenture2024equipo03inventario.Controller;

import ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput.OperacionDTO;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @Autowired
    private Sender sender;

    @GetMapping
    public String prueba() {
        OperacionDTO operacion = new OperacionDTO();
        operacion.setCantidad(10);
        operacion.setProductoid(1L);
        operacion.setFecha(LocalDateTime.now());

        sender.sendMessage(operacion);
        return "Prueba";
    }
}
