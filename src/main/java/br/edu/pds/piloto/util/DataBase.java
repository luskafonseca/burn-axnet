package br.edu.pds.piloto.util;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataBase {


	 @Bean    
	    public DataSource getDataSource() throws URISyntaxException {

	        URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.url(dbUrl);
	        dataSourceBuilder.username(username);
	        dataSourceBuilder.password(password);
	        return dataSourceBuilder.build();
	    }


	
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("postgres://eqqqjveokallfb:f6b519ec5963032bb579e7db985768fd5fe333554e4c07e85045b928b3502ea7@ec2-34-233-115-14.compute-1.amazonaws.com:5432/d337h8m2d3f5gg");
		dataSource.setUsername("eqqqjveokallfb");
		dataSource.setPassword("f6b519ec5963032bb579e7db985768fd5fe333554e4c07e85045b928b3502ea7");

		return dataSource;
	}*/

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
		adapter.setPrepareConnection(true);

		return adapter;
	}
}
