package com.aidanchadha.mcp_autoreg.pojo;

import jakarta.ws.rs.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
public class ToolUsage {
    private HttpMethod method;
}
