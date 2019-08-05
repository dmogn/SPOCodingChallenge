package com.github.dmogn.spo;

import com.github.dmogn.spo.model.OptimalStaffRequest;
import com.github.dmogn.spo.model.OptimalStaffResponse;
import com.github.dmogn.spo.model.StructureStaffRequirement;
import java.util.LinkedList;
import java.util.List;

/**
 * Calculation algorithm.
 */
public class OptimalStaff {
    /**
     * Our partner is free to decide how many Senior and Junior Cleaners 
     * are to be sent to clean a structure but there always needs to be 
     * at least one Senior cleaner at every structure to lead the juniors. 
     * 
     * The goal is to minimize overcapacity at every structure.
     * 
     * @param request
     * @return OptimalStaffResponse
     */
    public static OptimalStaffResponse calculateStaffRequirements(OptimalStaffRequest request) {
        final List<StructureStaffRequirement> optimalStuff = new LinkedList<>();
        
        for (final int rooms : request.getRooms()) {
            optimalStuff.add(
                calculateStaffRequirements(rooms, request.getSenior(), request.getJunior())
            );
        }
        
        return new OptimalStaffResponse(optimalStuff);
    }
    
    /**
     * The goal is to minimize overcapacity.
     * 
     * There always needs to be at least one Senior cleaner.
     * 
     * @param rooms
     * @param seniorCapacity
     * @param juniorCapacity
     * @return Staff requirement for the Structure.
     */
    protected static StructureStaffRequirement calculateStaffRequirements(
            final int rooms, 
            final int seniorCapacity, 
            final int juniorCapacity) {
        
        if (seniorCapacity >= rooms) {
            // The first senior cleaner can do the job himself
            // no additional requirements in this case
            return new StructureStaffRequirement(1, 0);
        }
        
        int bestOvercapacity = Integer.MAX_VALUE;
        int bestSeniorCount = Integer.MAX_VALUE;
        int bestJuniorCount = Integer.MAX_VALUE;
        
        for (int senior = 1; senior <= rooms/seniorCapacity + 1; senior++) 
            for (int junior = 0; junior <= rooms/juniorCapacity + 1; junior++) {
                final int capacity = senior*seniorCapacity + junior*juniorCapacity;
                
                if (capacity < rooms)
                    continue;// undercapacity
                
                if (capacity == rooms) {
                    // optimal result
                    return new StructureStaffRequirement(senior, junior);
                }
                
                final int overcapacity = capacity - rooms;
                
                if (overcapacity < bestOvercapacity) {
                    bestOvercapacity = overcapacity;
                    bestSeniorCount = senior;
                    bestJuniorCount = junior;
                }
                
                // overcapacity reached
                break;
            }
        
        // the result with minimal overcapacity
        return new StructureStaffRequirement(bestSeniorCount, bestJuniorCount);
    }
}
