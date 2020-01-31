package com.rationaleemotions.internal.locators;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WaitConditionTest {
    @Test(dataProvider = "getTestData")
    public void testAllCombinations(String rawText, WaitCondition expected) {
        Assert.assertEquals(WaitServiceListener.parse(rawText), expected);
    }

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][] {
            {null, DefaultWaitConditions.AVAILABLE},
            {"", DefaultWaitConditions.AVAILABLE},
            {"AVAILABLE", DefaultWaitConditions.AVAILABLE},
            {"available", DefaultWaitConditions.AVAILABLE},
            {"IdontExist", DefaultWaitConditions.AVAILABLE},
            {"vIsIbLe", DefaultWaitConditions.VISIBLE},
            {"Clickable", DefaultWaitConditions.CLICKABLE}
        };
    }
}