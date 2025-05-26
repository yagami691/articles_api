package articles.articles.articles;

import articles.articles.articles.articlesandcomments.Articles;
import articles.articles.articles.repository.ArticlesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ArticlesConfig {

    @Bean
    CommandLineRunner commandLineRunner (ArticlesRepository articlesRepository) {
        return args -> {
                 Articles remoteJob  = new Articles (
                         "The Rise of Remote Work: Is the Office Dead?",
                         " The pandemic accelerated a global shift to remote work. " +
                                 "While some companies are returning to office spaces, " +
                                 "many are embracing hybrid or fully remote models.",
                         "2024-09-15"
                    );

            Articles healthcare = new Articles (
                    "AI in Healthcare: Promise and Peril",
                    " Artificial Intelligence is revolutionizing diagnostics and patient care, " +
                            "but concerns about data privacy and ethical use are rising.",
                    "2025-01-04"
            );
            Articles redefiningSuccess  = new Articles (
                    "Why Gen Z is Redefining Success",
                    " Unlike previous generations, Gen Z prioritizes work-life balance, " +
                            "mental health, and meaningful careers over traditional success markers.",
                    "2025-03-21"

            );
            Articles climateChange = new Articles (
                    "Climate Change and Urban Planning: A Critical Intersection",
                    "Cities worldwide are adapting infrastructure to combat rising temperatures and extreme weather, " +
                            "integrating sustainability into development.",
                    "2024-11-30"
            );
            Articles futureOfEducation = new Articles (
                    "The Future of Education: Beyond the Classroom",
                    ": With e-learning platforms and virtual classrooms booming, " +
                            "traditional education is being reshaped for the digital age.",
                    " 2025-02-10"
            );
            Articles bitcoinVolatility  = new Articles (
                    "Bitcoin’s Volatility: Risk or Opportunity?",
                    " Bitcoin continues to experience dramatic price swings, " +
                            "making it both a risky investment and a potential opportunity for savvy traders.",
                    "2025-04-08"
            );
            Articles  spaceTourism = new Articles (
                    "Space Tourism: The Next Frontier or Just for the Rich?",
                    " Private spaceflight companies are opening space tourism " +
                            "to civilians—but the price tag remains out of reach for most.",
                    " 2025-05-01"
            );
            articlesRepository.saveAll(List.of(remoteJob, healthcare, redefiningSuccess,
                    climateChange, futureOfEducation, bitcoinVolatility, spaceTourism));
        };
    }
}
