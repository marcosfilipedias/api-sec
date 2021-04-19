package com.personal.apisecurity.jwt;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.personal.apisecurity.model.dto.UserTokenDetailsDTO;
import com.personal.apisecurity.model.dto.UserAuthDTO;
import com.personal.apisecurity.service.UserService;
import com.personal.apisecurity.utils.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


/**
 * Classe responsável por criar e
 * validar o token de acesso
 * utilizado no contexto de segurança
 * 
 * Implementação de AbstractTokenProvider
 */

@Component
public class TokenProvider implements AbstractTokenProvider<Authentication>{
	
	private static final String AUTHORITIES_KEY = "auth";
    private static final String CLAIM_DETAIL = "details";
    
    private final UserService userService;
        
    public TokenProvider(UserService userService) {
		this.userService = userService;
	}

	@Override
    @PostConstruct
    public void init() {
    }
	
	/**
     * Método utilizado para criar um
     * token para uma autenticação  
     * com um tempo de sessao especifico
     * 
     */
	@Override
	public String createToken(Authentication authentication, UserAuthDTO userAuthDTO, String system, Integer userProfile) {
		
		Builder builder = JWT.create().withSubject(authentication.getName())
				.withClaim(SecurityConstants.CLAIM_SESSION_USER, userAuthDTO.getLogin())
				.withClaim(SecurityConstants.CLAIM_ID_USER, authentication.getDetails().toString());
	    
	    return builder.withExpiresAt(Date.from(LocalDate.now().plusYears(1L)
	    		.atStartOfDay(ZoneId.systemDefault()).toInstant())).sign(HMAC512(SecurityConstants.SECRET.getBytes()));
		
	}

	@Override
	public Authentication getData(String token) {
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token).getBody();
		Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		 // Recebe informações do usuário principal dos modelos recuperadas por um  UserDetails
        User principal = new User(claims.getSubject(), "", authorities);
        // Caso o retorno do valor para o qual a chave especificada é mapeada não for nula
        if (claims.get(CLAIM_DETAIL) != null) {
            UserTokenAuthentication usernamePasswordAuthenticationToken = new UserTokenAuthentication(principal, token, authorities);
            usernamePasswordAuthenticationToken.setDetails(GenericEntitySerialization.convertJsonToObject(claims.get(CLAIM_DETAIL).toString(), UserTokenDetailsDTO.class));
            return usernamePasswordAuthenticationToken;
        }
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}

	public boolean validateToken(String authToken) {
		return this.validateToken(authToken, SecurityConstants.SECRET);
	}
	
}
