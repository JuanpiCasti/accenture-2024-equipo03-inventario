package ar.frba.utn.sharksales.accenture2024equipo03inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ.RabbitAmqpRunner;

@SpringBootApplication
@EnableScheduling
public class RabbitAmqpTutorialsApplication {


    @Bean
    public CommandLineRunner runnerInventario() {
        return new RabbitAmqpRunner();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitAmqpTutorialsApplication.class, args);
    }


}