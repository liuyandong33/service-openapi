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
    private static final String SCOPES = "USER";
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String PASSWORD = "password";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String SCOPE_APP = "APP";
    private static final String SCOPE_POS = "POS";
    private static final String GRANT_TYPES = "client_credentials,password,authorization_code";

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(clientId);

        Set<String> authorizedGrantTypes = new HashSet<String>();
        authorizedGrantTypes.add(AUTHORIZATION_CODE);
        baseClientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
        baseClientDetails.setAccessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS);

        Collection<String> scope = new HashSet<String>();
        scope.add("all");
        baseClientDetails.setScope(scope);

        Set<String> registeredRedirectUris = new HashSet<String>();
        registeredRedirectUris.add("http://www.baidu.com");
        baseClientDetails.setRegisteredRedirectUri(registeredRedirectUris);
        return baseClientDetails;
    }
}
