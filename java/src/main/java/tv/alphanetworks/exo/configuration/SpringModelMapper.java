package tv.alphanetworks.exo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringModelMapper {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();

    }
}
