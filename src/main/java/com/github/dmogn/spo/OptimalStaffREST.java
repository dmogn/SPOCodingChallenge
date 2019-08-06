package com.github.dmogn.spo;

import com.github.dmogn.spo.model.OptimalStaffRequest;
import com.github.dmogn.spo.model.OptimalStaffResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Endpoint.
 */
@Api("Cleaning staff requirements calculation API")
@RestController
@RequestMapping("/api/v1")
public class OptimalStaffREST {
    
    @ApiOperation(value = "Calculate Staff Requirements")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully calculated result"),
        @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/calculateStaffRequirements")
    public ResponseEntity<OptimalStaffResponse> calculateStaffRequirements(
            @ApiParam(required = true) 
            @RequestBody 
                    OptimalStaffRequest request) {
        // input validation
        if (request.getRooms().length > Configuration.MAX_STRUCTURES_COUNT_IN_PORTFOLIO) {
            return ResponseEntity.badRequest().build();
        }
        
        if (request.getSenior() <= 0 || request.getJunior() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        
        for (int rooms : request.getRooms()) {
            if (rooms <=  0 || rooms > Configuration.MAX_ROOMS_COUNT_IN_STRUCTURE) {
                return ResponseEntity.badRequest().build();
            }
        }
        
        // calculation
        return ResponseEntity.ok(
                OptimalStaff.calculateStaffRequirements(request)
        );
    }
}
