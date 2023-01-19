package com.cg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.LoginReq;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.service.ICustomerAuthenticationService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
//@RequestMapping("/auth")
public class ICustomerAuthenticationController {
	@Autowired
    private ICustomerAuthenticationService customerauthenticationservice;

    @PostMapping("/login")
    public ResponseEntity<Customer> doLogin(@RequestBody LoginReq loginReq){
        Customer customer = customerauthenticationservice.login(loginReq.getEmail(),loginReq.getPassword());
        ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
        return responseEntity;

}
}
