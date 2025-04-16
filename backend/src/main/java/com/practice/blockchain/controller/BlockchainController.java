package com.practice.blockchain.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
public class BlockchainController {

    @PostMapping("create")
    public void createBlock() {}
}
