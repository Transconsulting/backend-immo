package com.immobilier.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.JwtRequest;
import com.immobilier.dto.JwtResponse;
import com.immobilier.dto.UtilisateurDto;
import com.immobilier.model.Utilisateur;
import com.immobilier.repository.UtilisateurRepository;
import com.immobilier.security.JwtTokenUtil;
import com.immobilier.service.UtilisateurService;
import com.immobilier.serviceImple.JwtUserDetailsService;
 



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@CrossOrigin
public class JwtAuthenticationController {
    Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
            
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        logger.info("atuehticating user user");
        
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        logger.info("user authenticated ");

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        logger.info("user loaded ");

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(username);
            if (utilisateur.isPresent()) {
            	utilisateur.get().setOnline(true);
                utilisateurRepository.save(utilisateur.get());
			}
            
        } catch (DisabledException e) {
            logger.info("USER_DISABLED");
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            logger.error("INVALID_CREDENTIALS",e);
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception e) {
            logger.error("Exception",e);
            throw new Exception("Exception", e);
        }
    }
    
    
    @GetMapping("/getUtilisateur")
    public UtilisateurDto getUtilisateurByUsername() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserDetails userDetails = (UserDetails) auth.getPrincipal();
		return utilisateurService.getUtilisateurByEmail(userDetails.getUsername());
	}
    
    @GetMapping("/getprofile")
    public UserDetails loadUserByUsername() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserDetails userDetails = (UserDetails) auth.getPrincipal();
		return userDetails;
	}

}
