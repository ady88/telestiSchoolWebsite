package home.telestischool;

import home.telestischool.model.PageInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author Adrian
 */
@SpringBootApplication
@EnableJpaRepositories("home.telestischool.repository")
@Profile("production")
public class ProdDatabaseConfig {

    private static final Logger LOG = Logger.getLogger(ProdDatabaseConfig.class.getName());

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String databaseUrl = System.getenv("DATABASE_URL");
        if (databaseUrl == null) {
            LOG.severe("the database URL is null");
            return null;
        }
        LOG.info(String.format("The databaseUrl is: %s", databaseUrl));
        URI dbUri = new URI(databaseUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

        LOG.info(String.format("the final dbURL is: %s", dbUrl));

        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(dbUrl)
                .driverClassName("org.postgresql.Driver")
                .build();

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder) throws URISyntaxException {
        return builder
                .dataSource(dataSource())
                .packages(PageInfo.class)
                .persistenceUnit("d6prbg1ceja1kq")
                .build();
    }
}
