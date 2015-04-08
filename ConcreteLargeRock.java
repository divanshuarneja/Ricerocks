/**
 * Concrete Factory class to produce Large Rocks
 * 
 * @Team15
 * 
 */
public class ConcreteLargeRock implements RockGenerator 
{
    public Rock makeRock(String explodedRockType)
    {
        return new LargeRock();
    }
}
