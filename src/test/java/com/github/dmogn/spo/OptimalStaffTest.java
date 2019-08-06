package com.github.dmogn.spo;

import com.github.dmogn.spo.model.OptimalStaffRequest;
import com.github.dmogn.spo.model.OptimalStaffResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class OptimalStaffTest {

    /**
     * In: { “rooms”: [24, 28], “senior”: 11, “junior”: 6 }
     * Out: [ {senior: 2, junior: 1}, {senior: 2, junior: 1} ]
     */
    @Test
    public void testCase1() {        
        final OptimalStaffRequest requestBody = new OptimalStaffRequest(
                new int[]{24, 28},
                11,
                6
        );
        
        final OptimalStaffResponse result = OptimalStaff.calculateStaffRequirements(requestBody);
        
        Assert.assertEquals(2, result.getOptimalStuff().size());
        
        Assert.assertEquals(2, result.getOptimalStuff().get(0).getSenior());
        Assert.assertEquals(1, result.getOptimalStuff().get(0).getJunior());
        
        Assert.assertEquals(2, result.getOptimalStuff().get(1).getSenior());
        Assert.assertEquals(1, result.getOptimalStuff().get(1).getJunior());
    }
    
    /**
     * In: { “rooms”: [35, 21, 17, 28], “senior”: 10, “junior”: 6 }
     * Out: [ {senior: 3, junior: 1}, {senior: 1, junior: 2}, {senior: 2, junior: 0}, {senior: 1, junior: 3} ]
     */
    @Test
    public void testCase2() {        
        final OptimalStaffRequest requestBody = new OptimalStaffRequest(
                new int[]{35, 21, 17, 28},
                10,
                6
        );
        
        final OptimalStaffResponse result = OptimalStaff.calculateStaffRequirements(requestBody);
        
        Assert.assertEquals(4, result.getOptimalStuff().size());
        
        Assert.assertEquals(3, result.getOptimalStuff().get(0).getSenior());
        Assert.assertEquals(1, result.getOptimalStuff().get(0).getJunior());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(1).getSenior());
        Assert.assertEquals(2, result.getOptimalStuff().get(1).getJunior());
        
        Assert.assertEquals(2, result.getOptimalStuff().get(2).getSenior());
        Assert.assertEquals(0, result.getOptimalStuff().get(2).getJunior());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(3).getSenior());
        Assert.assertEquals(3, result.getOptimalStuff().get(3).getJunior());
    }
    
    @Test
    public void testSingleSenior() {        
        final OptimalStaffRequest requestBody = new OptimalStaffRequest(
                new int[]{35, 21, 17, 28},
                35,
                1
        );
        
        final OptimalStaffResponse result = OptimalStaff.calculateStaffRequirements(requestBody);
        
        Assert.assertEquals(4, result.getOptimalStuff().size());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(0).getSenior());
        Assert.assertEquals(0, result.getOptimalStuff().get(0).getJunior());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(1).getSenior());
        Assert.assertEquals(0, result.getOptimalStuff().get(1).getJunior());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(2).getSenior());
        Assert.assertEquals(0, result.getOptimalStuff().get(2).getJunior());
        
        Assert.assertEquals(1, result.getOptimalStuff().get(3).getSenior());
        Assert.assertEquals(0, result.getOptimalStuff().get(3).getJunior());
    }
}
