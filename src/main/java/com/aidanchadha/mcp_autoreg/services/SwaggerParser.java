package com.aidanchadha.mcp_autoreg.services;

import com.aidanchadha.mcp_autoreg.interfaces.Parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SwaggerParser implements Parser {

    @Override
    public JsonObject parse(JsonObject input) {
        if (!validateInput(input)) {{
            return null;
        }}
        JsonObject result = new JsonObject();
        JsonObject tools = new JsonObject();
        JsonObject info = input.get("info").getAsJsonObject();

        // add title and version #, check in validate if title present so not checking
        result.add("ToolApiFamilyName", info.get("title"));

        if (info.has("version")) {
            result.add("Version", info.get("version"));
        }

        // pre validated in validate that we have at least 1 path
        JsonObject paths = input.get("paths").getAsJsonObject();
        Set<String> pathNames = paths.keySet();

        for (String tool : pathNames) { // loop through every path
            JsonObject toolJson = paths.get(tool).getAsJsonObject();
            Set<String> httpMethodsAvailable = toolJson.keySet();

            for (String method : httpMethodsAvailable) {
                JsonObject individualToolHttpMethodInfo = toolJson.get(method).getAsJsonObject();
                JsonObject individualToolHttpMethodInfoResult = new JsonObject();

                // pre validate in validateInput
                String toolName = individualToolHttpMethodInfo.get("operationId").getAsString();

                if (individualToolHttpMethodInfo.has("description")) {
                    individualToolHttpMethodInfoResult.addProperty("Description",
                            individualToolHttpMethodInfo.get("description").getAsString());
                }

                if (individualToolHttpMethodInfo.has("requestBody")) {
                    individualToolHttpMethodInfoResult.add("RequestBody",
                            individualToolHttpMethodInfo.get("requestBody").getAsJsonObject());
                }

                individualToolHttpMethodInfoResult.addProperty("toolPathName", tool);

                tools.add(toolName, individualToolHttpMethodInfoResult);
            }
        }
        result.add("tools", tools);
        return result;
    }

    @Override
    public Boolean validateInput(JsonObject input) {

        return true;
    }
}
