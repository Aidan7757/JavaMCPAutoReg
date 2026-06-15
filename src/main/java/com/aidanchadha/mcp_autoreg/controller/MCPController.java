package com.aidanchadha.mcp_autoreg.controller;

import com.aidanchadha.mcp_autoreg.pojo.DomainToolFamily;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MCPController {

    @GetMapping("/healthCheck")
    String healthCheck() {
        return "MCP Service is healthy.";
    }

    @GetMapping("/getTools")
    ResponseEntity<DomainToolFamily> getTools() {
        DomainToolFamily domainToolFamily = new DomainToolFamily(null, null, null);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(domainToolFamily);
    }

}
