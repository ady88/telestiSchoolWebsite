package home.telestischool;

import home.telestischool.service.IWebPageService;
import home.telestischool.service.MockSchoolWebPageService;
import home.telestischool.service.SchoolWebPageService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
public class TelestischoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelestischoolApplication.class, args);
    }

//    @Bean
//    @Qualifier("b")
//    public IWebPageService mockWebPageService() {
//        return new MockSchoolWebPageService();
//    }

//    @Bean
//    @Qualifier("a")
//    public IWebPageService webPageService() {
//        return new SchoolWebPageService();
//    }

    /**
     * Needed to be able to inject session beans in the Controller class. Build
     * is not possible otherwise
     * http://tuhrig.de/making-a-spring-bean-session-scoped/
     *
     * @return
     */
    @Bean
    public CustomScopeConfigurer customScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("session", new SimpleThreadScope());
        configurer.setScopes(scopes);

        return configurer;
    }

    /**
     * Needed to be able to inject session beans in the Controller class. Build
     * is not possible otherwise.
     * http://tuhrig.de/making-a-spring-bean-session-scoped/
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

//    @Bean
//    @Qualifier("b")
//    public IWebPageService webPageService() {
//        return new MockSchoolWebPageService();
//    }
//    @Bean
//    public DataSource dataSource() throws URISyntaxException {
//        String databaseUrl = System.getenv("DATABASE_URL");
//        if (databaseUrl == null) {
//            LOG.severe("the database URL is null");
//            return null;
//        }
//        LOG.info(String.format("The databaseUrl is: %s", databaseUrl));
//        URI dbUri = new URI(databaseUrl);
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
//
//        LOG.info(String.format("the final dbURL is: %s", dbUrl));
//
//        return DataSourceBuilder
//                .create()
//                .username(username)
//                .password(password)
//                .url(dbUrl)
//                .driverClassName("org.postgresql.Driver")
//                .build();
//
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//            EntityManagerFactoryBuilder builder) throws URISyntaxException {
//        return builder
//                .dataSource(dataSource())
//                .packages(PageInfo.class)
//                .persistenceUnit("d6prbg1ceja1kq")
//                .build();
//    }
//    @Bean
//    public CommandLineRunner demo(PageInfoRepository repository, PageNewsRepository newsRepository) {
//        return (String[] args) -> {
//            LOG.info("demo starting here .....");
//            // add new record to DB
//            PageInfo infoP = new PageInfo("acasa", "ro");
//            repository.save(infoP);
//            PageNews news = new PageNews("acasa", "test headLine", "ro");
//            news.setContent("test content");
//            news.setAddDate(new Date());
//            newsRepository.save(news);
//            for (PageInfo info : repository.findByNameAndLanguage("acasa", "ro")) {
//                LOG.info(info.toString());
//            }
//
//            for (PageNews item : newsRepository.findByNamePageAndLanguage("acasa", "ro")) {
//                LOG.info(item.toString());
//            }
//
//            LOG.info("demo ended.");
//        };
//    }
}
