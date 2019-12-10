package com.aelion.appliActivite.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.appliActivite.config.JwtTokenUtil;
import com.aelion.appliActivite.dto.UserLightDTO;
import com.aelion.appliActivite.dto.jwt.JwtRequest;
import com.aelion.appliActivite.dto.jwt.JwtResponse;
import com.aelion.appliActivite.exceptions.NotAuthorizedException;
import com.aelion.appliActivite.services.IUserService;



@RestController
@RequestMapping(path = "/api/public")
public class PublicController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (DisabledException | BadCredentialsException e) {
			throw new NotAuthorizedException(e.getMessage());
		}		
	}
	
	@GetMapping(path = "/user")
	public List<UserLightDTO> findAll() {
		return userService.findAll()
				.stream()
				.map(u -> mapper.map(u, UserLightDTO.class))
				.collect(Collectors.toList());
	}
}
