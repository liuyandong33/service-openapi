package build.dream.openapi.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;

import javax.sql.DataSource;
import java.util.UUID;

public class CustomAuthorizationCodeServices extends JdbcAuthorizationCodeServices {
    public CustomAuthorizationCodeServices(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String createAuthorizationCode(OAuth2Authentication authentication) {
        String code = DigestUtils.sha256Hex(UUID.randomUUID().toString());
        store(code, authentication);
        return code;
    }
}
