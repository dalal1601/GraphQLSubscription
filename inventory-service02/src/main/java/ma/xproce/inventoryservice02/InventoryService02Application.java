package ma.xproce.inventoryservice02;

import dao.entities.Creator;
import dao.entities.Video;
import dao.repositories.CreatorRepository;
import dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dao.repositories")
@EntityScan(basePackages = "dao.entities")

public class InventoryService02Application {

    public static void main(String[] args) {
        SpringApplication.run(InventoryService02Application.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            // Créer des créateurs
            List<Creator> creators = List.of(
                    Creator.builder().name("John Doe").email("john.doe@example.com").build(),
                    Creator.builder().name("Jane Smith").email("jane.smith@example.com").build()
            );

            // Sauvegarder les créateurs dans la base de données
            creatorRepository.saveAll(creators);

            // Créer des vidéos associées aux créateurs avec datePublic et url
            List<Video> videos = List.of(
                    Video.builder()
                            .name("Spring Boot Tutorial")
                            .description("Learn Spring Boot")
                            .datePublic(new Date())  // Set current date or customize it
                            .url("https://example.com/spring-boot-tutorial")
                            .crt(creators.get(0))  // Assign creator
                            .build(),
                    Video.builder()
                            .name("Angular Tutorial")
                            .description("Learn Angular")
                            .datePublic(new Date())  // Set current date or customize it
                            .url("https://example.com/angular-tutorial")
                            .crt(creators.get(1))  // Assign creator
                            .build()
            );

            // Sauvegarder les vidéos dans la base de données
            videoRepository.saveAll(videos);

            System.out.println("Database initialized with creators and videos.");
        };
    }

}
