////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.fail;

import org.junit.Test;

public class AppTest {

    @Test
    public void SumOfPrice_EmptyList_Expected0()//0 0
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_MoreThan20Elements_RestaurantBillExceptionThrown()// 15 15
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Pizze_RestaurantBillExceptionThrown()// 25 0
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Primi_RestaurantBillExceptionThrown()// 0 22
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_MoreThan20PizzeAndMoreThan20Primi_RestaurantBillExceptionThrown()// 23 21
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20AndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()// 15 0 >100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 7 0 >100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAnd10OrLessPizzeTotalPriceLessThan100Euro_BillCalculated()// 6 * <100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAndMoreThan10PizzeTotalPriceLessThan100Euro_BillCalculatedAndLeastExpensivePizzaGratis()// 11 * <100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAnd10OrLessPizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 6 * >100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()// 11 * >100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20PrimiTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 0 * >100
    {
        fail("Not yet implemented");
    }

    @Test
    public void SumOfPrice_LessThan20PrimiTotalPriceLessThan100Euro_BillDiscountedOf5Percent()// 0 * <100
    {
        fail("Not yet implemented");
    }
}
