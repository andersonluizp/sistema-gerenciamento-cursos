package br.pucminas.andersonluiz.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtTokenAuthenticationFilter extends GenericFilterBean {	

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider=jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		try {
			
		
			String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		
			if(token != null && jwtTokenProvider.validateToken(token)) {
			
				Authentication authentication = jwtTokenProvider.getAuthentication(token);
			
				if(authentication != null)
					SecurityContextHolder.getContext().setAuthentication(authentication);
			
			}
		
			chain.doFilter(request, response);
			
		}
		catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| SignatureException | UsernameNotFoundException e) {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}
	
	
	
	

}
