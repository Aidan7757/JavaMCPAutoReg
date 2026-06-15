package com.aidanchadha.mcp_autoreg.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class DomainToolFamily {
    private String domainTeamName;
    private String domainTeamDescription;
    private ArrayList<Tool> tools;
}
