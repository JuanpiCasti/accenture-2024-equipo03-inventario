package rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"rabbitMQ","hello-world"})
@Configuration
public class rabbitConfig {

  @Bean
  public Queue hello() {
    return new Queue("hello");
  }

  @Profile("receiver")
  @Bean
  public Receiver receiver() {
    return new Receiver();
  }

  @Profile("sender")
  @Bean
  public Sender sender() {
    return new Sender();
  }
}