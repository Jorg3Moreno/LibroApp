package ec.prueba.cobiscorp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "ec.prueba.cobiscorp.repository" })
@EnableTransactionManagement
public class DatabaseConfiguration {}
