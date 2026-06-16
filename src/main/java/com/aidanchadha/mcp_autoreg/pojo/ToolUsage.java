package com.aidanchadha.mcp_autoreg.pojo;

import com.google.gson.JsonObject;
import jakarta.ws.rs.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToolUsage {

    private HttpMethod method;
    private JsonObject requestBodyDetails;

    public ToolUsage(HttpMethod method) {
        this.method = method;
    }
}
