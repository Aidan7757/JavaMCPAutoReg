package com.aidanchadha.mcp_autoreg.services;

import com.aidanchadha.mcp_autoreg.interfaces.Parser;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

@Service
public class JsonParser implements Parser {
    @Override
    public JsonObject parse() {
        return null;
    }
}
