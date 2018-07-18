package build.dream.openapi.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomClientDetailsService implements ClientDetailsService {
    public static final String RESOURCE_ID = "SERVICE-ROUTER";
    public static final String RESOURCE_IDS = "SERVICE-ROUTER,POS-SERVICE";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 7200;
    private static final String ALL = "all";
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String PASSWORD = "password";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String REFRESH_TOKEN = "refresh_token";

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(clientId);
        baseClientDetails.setClientSecret("{MD5}" + DigestUtils.md5Hex("123456"));

        Set<String> authorizedGrantTypes = new HashSet<String>();
        authorizedGrantTypes.add(AUTHORIZATION_CODE);
        authorizedGrantTypes.add(REFRESH_TOKEN);
        baseClientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
        baseClientDetails.setAccessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS);

        Collection<String> scope = new HashSet<String>();
        scope.add(ALL);
        baseClientDetails.setScope(scope);

        Set<String> registeredRedirectUris = new HashSet<String>();
        registeredRedirectUris.add("http://www.baidu.com");
        baseClientDetails.setRegisteredRedirectUri(registeredRedirectUris);
        return baseClientDetails;
    }
}
