package tests;

import com.aidanchadha.mcp_autoreg.services.SwaggerParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class SwaggerParserTest {

    public boolean testParse()  {
        String testJsonString = """
                {
                  "openapi": "3.0.3",
                  "info": {"title": "Products API", "version": "1.0.0"},
                  "paths": {
                    "/products": {
                      "get": {
                        "operationId": "listProducts",
                        "summary": "List products",
                        "description": "Fetch all products.",
                        "responses": {"200": {"description": "OK"}}
                      },
                      "post": {
                        "operationId": "createProduct",
                        "summary": "Create product",
                        "description": "Creates a product.",
                        "requestBody": {
                          "content": {
                            "application/json": {
                              "schema": {
                                "type": "object",
                                "properties": {
                                  "name": {"type": "string"},
                                  "price": {"type": "number"}
                                }
                              }
                            }
                          }
                        },
                        "responses": {"201": {"description": "Created"}}
                      }
                    }
                  }
                }
                """;
        JsonObject testJson = JsonParser.parseString(testJsonString).getAsJsonObject();
        JsonObject resultJson = new SwaggerParser().parse(testJson);
        System.out.println("Result JSON: " + resultJson);
        return false;
    }

    public static void main(String[] args) throws JsonSyntaxException {
        SwaggerParserTest swaggerParserTest = new SwaggerParserTest();
        swaggerParserTest.testParse();
    }

}
