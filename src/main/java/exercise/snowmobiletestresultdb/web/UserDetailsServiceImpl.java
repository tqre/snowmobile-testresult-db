package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import exercise.snowmobiletestresultdb.domain.User;
import exercise.snowmobiletestresultdb.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User current = userRepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(
				username, current.getPwdHash(),
				AuthorityUtils.createAuthorityList(current.getRole()));
		return user;
	}
	
}