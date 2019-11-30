package br.pucminas.andersonluiz.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	@Autowired
	private JwtProperties jwtProperties;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private String secretKey;

	@PostConstruct
	protected void init() {
		secretKey=Base64.getEncoder().encodeToString(jwtProperties.getSecretKey().getBytes());
	}
	
	public String createToken(String username) {
		
		Date now = new Date();
		Date validity = new Date(now.getTime()+jwtProperties.getValidityInMilliseconds());
		
		return Jwts.builder().setId(UUID.randomUUID().toString()).setSubject(username)
				.setIssuedAt(now).signWith(SignatureAlgorithm.HS256, this.secretKey)
				.setExpiration(validity).compact();
		
	}
	
	public Authentication getAuthentication(String token) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
		
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
		
	}
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	public String resolveToken(HttpServletRequest request) {
		
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
			return bearerToken.substring(7, bearerToken.length());
		
		return null;
		
	}
	
	public boolean validateToken(String token) {
		
		Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
		
		if(claims.getBody().getExpiration().before(new Date()))
			return false;
		
		return true;
		
	}
	

}
