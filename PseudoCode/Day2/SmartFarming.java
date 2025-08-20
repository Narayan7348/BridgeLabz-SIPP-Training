/*
ABSTRACT CLASS Crop
    PROTECTED FIELDS
        name, growthPeriod, waterRequirement
    
    ABSTRACT METHODS
        calculateWaterRequirement()
        harvestTime()
        expectedYield()

CLASS Rice EXTENDS Crop
    OVERRIDE calculateWaterRequirement()
        RETURN based on season and growth stage
    
    OVERRIDE harvestTime()
        CALCULATE based on planting date

CLASS Wheat EXTENDS Crop
    Similar implementations as Rice with different parameters
*/