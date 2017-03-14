package com.rafaelmd.pullrequest.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
public class SessionProvider {

	@Bean
	public Session getSession() {
        Cluster cluster = Cluster.builder()
                .withPort(9042)
                .addContactPoint("127.0.0.1")
                .build();
        cluster.getConfiguration().getSocketOptions().setReadTimeoutMillis(9999);
        return cluster.connect();
	}
}
