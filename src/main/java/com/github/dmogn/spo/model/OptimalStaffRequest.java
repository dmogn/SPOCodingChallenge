package com.github.dmogn.spo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptimalStaffRequest {
    /**
     * Array of rooms count for every structure.
     */
    private int[] rooms;
    
    /**
     * Cleaning capacity Senior Cleaner.
     */
    private int senior;
    
    /**
     * Cleaning capacity Junior Cleaner.
     */
    private int junior;
}
