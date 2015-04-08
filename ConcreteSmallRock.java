/**
 * Concrete Factory class to produce Small Rocks
 * 
 * @Team15
 * 
 */
public class ConcreteSmallRock  implements RockGenerator
{
    public Rock makeRock(String explodedRockType)
    {
        return new SmallRock();
    }
}

