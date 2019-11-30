package br.pucminas.andersonluiz.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
	
	private String secretKey = "secret";
	
	private long validityInMilliseconds =  3600000;

	public String getSecretKey() {
		return secretKey;
	}

	public long getValidityInMilliseconds() {
		return validityInMilliseconds;
	}	
	

}
