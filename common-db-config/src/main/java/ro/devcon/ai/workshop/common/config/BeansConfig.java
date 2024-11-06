package ro.devcon.ai.workshop.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "ro.devcon.ai.workshop.common",
        "ro.devcon.ai.workshop.common.domain",
        "ro.devcon.ai.workshop.common.service"
})
@EnableJpaRepositories(basePackages = "ro.devcon.ai.workshop.common.domain.repository")
@EntityScan(basePackages = "ro.devcon.ai.workshop.common.domain.entity")
public class BeansConfig {
}
