package ro.devcon.ai.workshop.structured;

import org.springframework.context.annotation.ComponentScan;
import ro.devcon.ai.workshop.common.config.BeansConfig;
import ro.devcon.ai.workshop.common.service.VectorService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootApplication
@Import(BeansConfig.class)
@ComponentScan(basePackages = {
        "ro.devcon.ai.workshop.common"
})
public class PromptWithContextRetrievalMain {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PromptWithContextRetrievalMain.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Bean
    public ApplicationRunner runner(VectorService vectorService) {
        return args -> {
            System.out.println("Storing some embeddings...");

            // save some embeddings
            //vectorService.storeEmbedding("Spring Boot is a Java framework");
            //vectorService.storeEmbedding("Python Django is a web framework");
            //vectorService.storeEmbedding("Java helps in enterprise development");

            System.out.println("Querying the vector database...");

            // search for similar content
            List<String> results = vectorService.findSimilar(
                    "What Java frameworks exist?",
                    2
            );

            System.out.println("Results:");
            results.forEach(System.out::println);
        };
    }
}
