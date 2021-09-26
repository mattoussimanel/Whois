package com.example.demo.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private DataSource dataSource;
	@Value("${spring.queries.users-query}")
	private String usersQuery; 
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.
		jdbcAuthentication()
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(rolesQuery)
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
		}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/").permitAll()
		
		// accèspour toususers
		.antMatchers("/login").permitAll() // accèspour toususers
		.antMatchers("/registration").permitAll() // accèspour toususers
		.antMatchers("/getclienthistorique").permitAll() // accèspour toususers
		.antMatchers("/findByAcctstatustype/{acctstatustype}").permitAll() // accèspour toususers
		.antMatchers("/findByFramedipaddress/{framedipaddress}").permitAll() // accèspour toususers
		.antMatchers("/findBetween/**").permitAll() // accèspour toususers
		.antMatchers("/findipBetween/**").permitAll() // accèspour toususers
		.antMatchers("/finddateBetween/**").permitAll() // accèspour toususers
		.antMatchers("/role/**").permitAll()
		.antMatchers("/addP").permitAll()
		.antMatchers("/listProduct").permitAll()
		.antMatchers("/addProduct").permitAll()
		.antMatchers("/listProducts.html").permitAll()
		.antMatchers("/addProduct.html").permitAll()
		.antMatchers("/addC").permitAll()
		.antMatchers("/addClient").permitAll()
		.antMatchers("/listClient").permitAll()
		.antMatchers("/listClients.html").permitAll()
		.antMatchers("/addClient.html").permitAll()
		.antMatchers("/accounts/**").permitAll()
		.antMatchers("/deleteClient/{id}").permitAll()
		.antMatchers("/changeName").permitAll()
		.antMatchers("/changeAdresse").permitAll()
		.antMatchers("/changeTelephone").permitAll()
		.antMatchers("/changeAttribute").permitAll()
		.antMatchers("/changeLogin").permitAll()
		.antMatchers("/changeIproute").permitAll()
		.antMatchers("/changeObservation").permitAll()
		.antMatchers("/changeOp").permitAll()
		.antMatchers("/changeCin").permitAll()
		.antMatchers("/api/**").permitAll()
		.antMatchers("/get").permitAll()
		.antMatchers("/index.html").permitAll()
		.antMatchers("/listClientt").permitAll()
		.antMatchers("/accueil").permitAll()
		.antMatchers("/Clienthisto").permitAll()
		.antMatchers("/clientshisto").permitAll()
		.antMatchers("/search").permitAll()
		.antMatchers("/rechercheframe").permitAll()
		.antMatchers("/findByAcctstarttime/**").permitAll()
		.antMatchers("/findAllWithAcctstarttimeBefore").permitAll()
		.antMatchers("/getstartclientMonthMonth/**").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers("/Accueil.html").permitAll()
		//.antMatchers("/provider/**").hasAuthority("ADMIN")
		//.antMatchers("/article/**").hasAuthority("USER").anyRequest()
		.antMatchers("/provider/**").hasAnyAuthority("ADMIN", "SUPERADMIN")
		.antMatchers("/article/**").hasAnyAuthority("USER", "SUPERADMIN").anyRequest()
		.authenticated().and().csrf().disable().formLogin() // l'accès defaitvia unformulaire
		.loginPage("/login").failureUrl("/login?error=true") // fixer lapage login
		.defaultSuccessUrl("/home") // page d'accueil aprèslogin avecsuccès
		.usernameParameter("email") // paramètresd'authentifications login etpassword
		.passwordParameter("password").and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // route dedeconnexionici/logut
		.logoutSuccessUrl("/login").and().exceptionHandling() // unefoisdeconnectéredirection verslogin
		.accessDeniedPage("/403"); }// laisserl'accès auxressources
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
		}
	}

