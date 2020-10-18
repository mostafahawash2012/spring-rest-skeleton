package com.spring.boot.config;

//@Configuration
public class SpringSecurityConfig {
}/*
	 * extends WebSecurityConfigurerAdapter {
	 * 
	 * // Create 2 users for demo
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication().withUser("user").password("{noop}password").
	 * roles("USER") .and()
	 * .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	 * 
	 * }
	 * 
	 * // Secure the endpoins with HTTP Basic authentication
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http // HTTP Basic authentication
	 * .httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET,
	 * "/user/**").hasRole("USER") .and().csrf().disable().formLogin() .disable(); }
	 * }
	 */
