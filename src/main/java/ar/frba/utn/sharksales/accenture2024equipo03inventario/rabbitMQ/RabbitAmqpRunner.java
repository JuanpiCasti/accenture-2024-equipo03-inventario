package ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ;

import org.springframework.boot.CommandLineRunner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


public class RabbitAmqpRunner implements CommandLineRunner {

  @Value("${tutorial.client.duration}")
  private int duration;

  @Autowired
  private ConfigurableApplicationContext ctx;

  @Override
  public void run(String... arg0) throws Exception {
    System.out.println("Ready ... running for " + duration + "ms");
  }
}