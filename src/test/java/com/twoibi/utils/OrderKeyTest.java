package com.twoibi.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderKeyTest {
    @Test
    public void  parse_ShouldReturnByName(){
        OrderKey key = OrderKey.parse("name");
        Assertions.assertTrue(key==OrderKey.BY_NAME);
    }
    @Test
    public void  parse_ShouldReturnByCapital(){
        OrderKey key = OrderKey.parse("capital");
        Assertions.assertTrue(key==OrderKey.BY_CAPITAL);

    }
    @Test
    public void  parse_ShouldReturnByRegion(){
        OrderKey key = OrderKey.parse("region");
        Assertions.assertTrue(key==OrderKey.BY_REGION);

    }
    @Test
    public void  parse_ShouldReturnBySubRegion(){
        OrderKey key = OrderKey.parse("subregion");
        Assertions.assertTrue(key==OrderKey.BY_SUBREGION);

    }
    @Test
    public void  parse_ShouldReturnByArea(){
        OrderKey key = OrderKey.parse("area");
        Assertions.assertTrue(key==OrderKey.BY_AREA);

    }
    @Test
    public void  parse_ShouldReturnNoOrder(){
        OrderKey key = OrderKey.parse("unexpected string");
        Assertions.assertTrue(key==OrderKey.NO_ORDER);

    }

}
