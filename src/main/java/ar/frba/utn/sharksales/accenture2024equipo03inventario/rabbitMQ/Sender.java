package ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ;

import ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput.OperacionDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;




public class Sender {

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private Queue bajoStockQueue;

  public void sendMessage(OperacionDTO operacion) {
    template.convertAndSend(bajoStockQueue.getName(), operacion);
    System.out.println(" [x] Sent message with OperacionDTO: " + operacion.toString());
  }
}