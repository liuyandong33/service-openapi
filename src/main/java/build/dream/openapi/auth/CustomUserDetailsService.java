package build.dream.openapi.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by liuyandong on 2017/4/3.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String password = "{MD5}" + DigestUtils.md5Hex("0");
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        User user = new User(userName, password, authorities);
        return user;
    }
}
