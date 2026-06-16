package com.aidanchadha.mcp_autoreg.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Tool {

    private String toolName;
    private String toolDescription;

    /**
     * Describes the details of the tool usage, such as the method,
     */
    private ToolUsage toolDetails;

}
