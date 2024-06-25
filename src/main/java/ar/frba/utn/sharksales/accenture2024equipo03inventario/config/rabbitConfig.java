package ar.frba.utn.sharksales.accenture2024equipo03inventario.config;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.rabbitMQ.Sender;


@Configuration
@EnableRabbit
public class rabbitConfig {

  @Value("${rabbitmq.queue}")
  private String queueName;

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(messageConverter);
    return rabbitTemplate;
  }



  @Bean
  public Queue bajo_stock() {
    return new Queue("bajo_stock", true);
  }



  @Bean
  public Sender sender() {
    return new Sender();
  }
}