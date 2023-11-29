package com.chanel.fsh.peps.nextgen.cms.zouani.util.security.ws;


import jakarta.validation.Valid;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.bean.User;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.common.SecurityParams;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.dao.RoleDao;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.dao.UserDao;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.jwt.JwtUtils;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.payload.request.LoginRequest;
import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userRepository;

    @Autowired
    RoleDao roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add(SecurityParams.JWT_HEADER_NAME, SecurityParams.HEADER_PREFIX + jwt);
        return ResponseEntity.ok()
                .headers(headers)
                .body(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
    }

}
