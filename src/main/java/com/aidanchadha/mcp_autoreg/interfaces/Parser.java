package com.aidanchadha.mcp_autoreg.interfaces;

import com.google.gson.JsonObject;

public interface Parser {

    /**
     * Parses the file's Json and returns a Json describing the tools
     */
    JsonObject parse(JsonObject input);

    /**
     * Validates that all the inputs are valid before we parse
     * @param input the json of the swagger file
     * @return true if the inputs are all valid and able to be parsed
     */
    Boolean validateInput(JsonObject input);
}
