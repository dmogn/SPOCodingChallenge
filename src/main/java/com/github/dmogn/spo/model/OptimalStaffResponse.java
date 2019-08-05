package com.github.dmogn.spo.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptimalStaffResponse {
    /**
     * The optimal number of Juniors and Seniors for every structure.
     */
    private List<StructureStaffRequirement> optimalStuff;
}
