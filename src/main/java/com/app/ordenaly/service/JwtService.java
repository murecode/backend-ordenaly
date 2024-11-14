package com.app.ordenaly.service;

import com.app.ordenaly.model.entity.User;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

  @Value("${security.jwt.expiration-minutes}")
  private long EXPIRATION_MINUTES;
  @Value("${security.jwt.secret-key}")
  private String SECRET_KEY;

  public String generateToken(User user, Map<String,Object> extraClaims) {

    //1.
    Date issueAt = new Date(System.currentTimeMillis());
    Date expiration = new Date(issueAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));

    //2.
    return Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(issueAt)
            .setExpiration(expiration)
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .signWith(generateKey(), SignatureAlgorithm.HS256)
            .compact();
  }

  //3.
  private Key generateKey() {
    byte[] secretKeyAsBytes = Decoders.BASE64.decode(SECRET_KEY);
    System.out.println("clave: " + new String(secretKeyAsBytes));
    return Keys.hmacShaKeyFor(secretKeyAsBytes);
  }

  //4.
  public String extractUsername(String jwt) {
    return Jwts.parser().setSigningKey(generateKey())
            .build()
            .parseClaimsJws(jwt).getBody().getSubject();
  }

}

//1. Configuracion de tiempos de expedicion y caducidad del token en milisegundos

/*2. Toma una serie de reclamos adicionales (extraClaims) y establece el tipo de token,
     su firma con una clave secreta generada y devuelve el token JWT como una cadena compacta */

/*3. Decodifica una clave secreta en base64, la imprime en la consola y luego la utiliza para
     generar una instancia de Key que se utilizará en la firma de tokens JWT. */

/*4. - Metodo que recibe un parámetro jwt de tipo String y devuelve un String. El parámetro jwt
       representa el JSON Web Token del cual queremos extraer el nombre de usuario.
     - Jwts.parser(): Llama al método estático parser de la clase Jwts, que crea una instancia de JwtParser.
     - .setSigningKey(generateKey()): Configura la clave de firma que se utilizará para verificar el JWT.
     - generateKey() debe ser implementado en otro lugar del código y debe devolver la clave de firma
       correcta (por ejemplo, una SecretKey o un String que representa la clave secreta).
     - .build(): Construye el JwtParser con la configuración proporcionada (en este caso, la clave de firma).
     - .parseClaimsJws(jwt): Parsea el JWT y lo valida usando la clave de firma. Si el token es válido
       y está correctamente firmado, este método devolverá un Jws<Claims> que contiene las claims (información) del JWT.
     - .getBody(): Obtiene el cuerpo (claims) del JWT, que es un objeto de tipo Claims.
     - .getSubject(): Obtiene el "subject" de las claims, que normalmente es el nombre de usuario o identificador del usuario.*/

// ANOTATIONS
/* @Value, se utiliza para inyectar valores directamente en campos de una clase desde
   el entorno de configuración de Spring, como properties files, variables de entorno,
   valores por defecto, etc. Esta anotación es parte de la inyección de dependencias de
   Spring y es especialmente útil para inyectar valores simples, como cadenas de texto,
   números u otros tipos de datos básicos. */