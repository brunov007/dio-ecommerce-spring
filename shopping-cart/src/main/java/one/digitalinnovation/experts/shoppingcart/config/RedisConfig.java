package one.digitalinnovation.experts.shoppingcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

//FIXME
@Configuration
@EnableRedisRepositories(basePackages = "one.digitalinnovation.experts.shoppingcart.repository")
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
        jedisConnection.setHostName("localhost");
        jedisConnection.setPort(6379);
        return jedisConnection;
    }

    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
