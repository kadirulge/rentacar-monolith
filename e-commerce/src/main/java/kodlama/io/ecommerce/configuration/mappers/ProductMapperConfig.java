package kodlama.io.ecommerce.configuration.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
