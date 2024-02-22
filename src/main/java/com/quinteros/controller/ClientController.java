package com.quinteros.controller;

import com.quinteros.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

}
