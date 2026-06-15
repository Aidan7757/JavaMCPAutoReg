package com.aidanchadha.mcp_autoreg.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class Tool {

    private String toolName;
    private String toolDescription;

    /**
     * Describes the details of the tool usage, such as the method,
     */
    @Autowired
    private ToolUsage toolDetails;

}
