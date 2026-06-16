package com.aidanchadha.mcp_autoreg.controller;

import com.aidanchadha.mcp_autoreg.pojo.DomainToolFamily;
import com.aidanchadha.mcp_autoreg.services.SwaggerParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.logging.*;

import java.io.IOException;

@RestController
public class MCPController {

    @Autowired
    SwaggerParser swaggerParser;

    private static final Logger logger = Logger.getLogger(MCPController.class.getName());


    @GetMapping("/healthCheck")
    String healthCheck() {
        return "MCP Service is healthy.";
    }

    @GetMapping("/getTools/{domainTeamName}")
    ResponseEntity<DomainToolFamily> getTools(@RequestParam String domainTeamName) {
        DomainToolFamily domainToolFamily = new DomainToolFamily(null, domainTeamName, null);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(domainToolFamily);
    }

    @PostMapping("/registerSwaggerTools")
    ResponseEntity<?> registerSwaggerTools(@RequestPart("SwaggerFile") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        String content = new String(file.getBytes(), java.nio.charset.StandardCharsets.UTF_8);
        JsonObject fileJsonContent = JsonParser.parseString(content).getAsJsonObject();

        JsonObject parseJsonResult = swaggerParser.parse(fileJsonContent);

        logger.log(Level.INFO, "Parse Json Result: " + parseJsonResult);

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

}
