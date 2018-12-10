////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    @Test
    public void SumOfPrice_EmptyList_Expected0()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_MoreThan20Elements_RestaurantBillExceptionThrown()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Pizze_RestaurantBillExceptionThrown()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Primi_RestaurantBillExceptionThrown()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_MoreThan20PizzeAndMoreThan20Primi_RestaurantBillExceptionThrown()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAnd10OrLessPizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20PrimiTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20AndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()
    {
        fail("Not yet implemented");
    }




 
    @Test
    public void SumOfPrice_2PizzeAnd2Primi_PriceIsLessThan100Euro()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_4PrimiAnd2Pizze_PriceIsLessThan100Euro()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_3Pizze_PriceIsLessThan100Euro()
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_3Primi_PriceIsLessThan100Euro()
    {
        fail("Not yet implemented");
    }

    

    @Test
    public void Sum_ListOfMoreThan10AndLessThan20Elements_PriceIsLessThan100EuroAndLeastExpensiveElementCosts0()
    {
        fail("Not yet implemented");
    }

    @Test
    public void Sum_ListOfPizzeAndPrimi()
    {
        fail("Not yet implemented");
    }
	
}
