package com.github.dmogn.spo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Cleaning staff requirements per Structure.
 */
@Data
@AllArgsConstructor
public class StructureStaffRequirement {
    /**
     * Count of required Senior Cleaners.
     */
    private int senior;
    /**
     * Count of required Junior Cleaners.
     */
    private int junior;
}
