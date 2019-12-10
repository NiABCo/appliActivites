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
import com.aelion.appliActivite.dto.ActivityLightDTO;
import com.aelion.appliActivite.dto.jwt.JwtResponse;
import com.aelion.appliActivite.dto.jwt.JwtRequest;
import com.aelion.appliActivite.exceptions.NotAuthorizedException;
import com.aelion.appliActivite.services.IActivityService;




@RestController
@RequestMapping(path = "/public")
public class PublicController {


	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private IActivityService activityService;
	
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
	
	@GetMapping("/activity/list")
	public List<ActivityLightDTO> getAllActivities() {
		return activityService.findAll().stream().map(activity -> mapper.map(activity, ActivityLightDTO.class)).collect(Collectors.toList());
	}
}
