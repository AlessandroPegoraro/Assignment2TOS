////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import java.util.*;

public class AppTest {
	private App testApp=new App();
	
    @Test
    public void SumOfPrice_EmptyList_Expected0()//0 0
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		double result=testApp.getOrderPrice(list);
    		assertEquals(0.0, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		fail(e.getMessage());
    	}	
    }

	@Test
	public void TestOfType_ListWithPizza_TypeOfPizza()
	{
		MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
		assertEquals(MenuItem.itemType.Pizza,p1.getType());
	}

        @Test
	public void TestOfType_ListWithPrimo_TypeOfPrimo()
	{
		MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
		assertEquals(MenuItem.itemType.Primo,k1.getType());
	}
    
	@Test
	public void TestOfName_ListWithPizza_NameOfPizza()
	{
		MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
		assertEquals("Margherita",p1.getName());
	}

        @Test
	public void TestOfName_ListWithPrimo_NameOfPrimo()
	{
		MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
		assertEquals("Pasta",k1.getName());
	}

    @Test
    public void SumOfPrice_MoreThan20Elements_RestaurantBillExceptionThrown()// 15 15
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<5;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
    			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
    			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);
    			list.add(p1); list.add(k1); list.add(p2); list.add(k2); list.add(p3); list.add(k3); 
    		}
    		testApp.getOrderPrice(list);
    		fail("Situazione di Errore non raggiunta");
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Pizze_RestaurantBillExceptionThrown()// 25 0
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<5;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "4 Stagioni", 5.0);
    			MenuItem p5=new MenuItem(MenuItem.itemType.Pizza, "Diavola", 6.0);
    			list.add(p1); list.add(p2); list.add(p3); list.add(p4); list.add(p5); 
    		}
    		testApp.getOrderPrice(list);
    		fail("Situazione di Errore non raggiunta");
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_OnlyMoreThan20Primi_RestaurantBillExceptionThrown()// 0 24
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<8;i++) {
    			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
    			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
    			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);
    			list.add(k1); list.add(k2); list.add(k3); 
    		}
    		testApp.getOrderPrice(list);
    		fail("Situazione di Errore non raggiunta");
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_MoreThan20PizzeAndMoreThan20Primi_RestaurantBillExceptionThrown()// 28 21
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<7;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "4 Stagioni", 5.0);
    			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
    			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
    			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);
    			list.add(p1); list.add(k1); list.add(p2); list.add(k2); list.add(p3); list.add(k3); list.add(p4);
    		}
    		testApp.getOrderPrice(list);
    		fail("Situazione di Errore non raggiunta");
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20AndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()// 18 0 >100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<6;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 5.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 7.5);
    			list.add(p1); list.add(p2); list.add(p3); 
    		}
    		double result=testApp.getOrderPrice(list);
    		assertEquals(97.85, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		fail(e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 7 0 >100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 15.0);
    		MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 15.5);
    		MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 17.5);
    		MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "Diavola", 18.0);
    		MenuItem p5=new MenuItem(MenuItem.itemType.Pizza, "Ananas", 10.5);
    		MenuItem p6=new MenuItem(MenuItem.itemType.Pizza, "Ananas e Bresaola", 15.5);
    		MenuItem p7=new MenuItem(MenuItem.itemType.Pizza, "Noci e Capperi", 17.5);
    		list.add(p1); list.add(p2); list.add(p3); list.add(p4); list.add(p5); list.add(p6);  list.add(p7);
    		double result=testApp.getOrderPrice(list);
    		assertEquals(104.025, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		fail(e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAnd10OrLessPizzeTotalPriceLessThan100Euro_BillCalculated()// 6 * <100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 5.0);
    		MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    		MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 7.5);
    		MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "Diavola", 8.0);
    		MenuItem p5=new MenuItem(MenuItem.itemType.Pizza, "Ananas", 10.5);
    		MenuItem p6=new MenuItem(MenuItem.itemType.Pizza, "Ananas e Bresaola", 15.5);
			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);    		
    		list.add(p1); list.add(k1); list.add(p2); list.add(k2); list.add(p3); list.add(k3); list.add(p4); list.add(p5); list.add(p6);
    		double result=testApp.getOrderPrice(list);
    		assertEquals(69.0, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		fail(e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAndMoreThan10PizzeTotalPriceLessThan100Euro_BillCalculatedAndLeastExpensivePizzaGratis()// 12 * <100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<3;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "4 Stagioni", 5.0);
    			list.add(p1); list.add(p2); list.add(p3); list.add(p4);
    		}
			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);
			list.add(k1); list.add(k2); list.add(k3);
			double result=testApp.getOrderPrice(list);
    		assertEquals(66.5, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAnd10OrLessPizzeTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 6 * >100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<2;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			list.add(p1); list.add(p2); list.add(p3);
    		}
			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 5.0);
			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 4.5);
			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 7.5);
			list.add(k1); list.add(k2); list.add(k3);
			double result=testApp.getOrderPrice(list);
    		assertEquals(42.0, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20ElementsAndMoreThan10PizzeTotalPriceMoreThan100Euro_BillDiscountedOf5PercentAndLeastExpensivePizzaGratis()// 12 * >100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<3;i++) {
    			MenuItem p1=new MenuItem(MenuItem.itemType.Pizza, "Margherita", 3.0);
    			MenuItem p2=new MenuItem(MenuItem.itemType.Pizza, "Capricciosa", 5.5);
    			MenuItem p3=new MenuItem(MenuItem.itemType.Pizza, "Viennese", 4.0);
    			MenuItem p4=new MenuItem(MenuItem.itemType.Pizza, "4 Stagioni", 5.0);
    			list.add(p1); list.add(p2); list.add(p3); list.add(p4);
    		}
			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 15.0);
			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 14.5);
			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 17.5);
			MenuItem k4=new MenuItem(MenuItem.itemType.Primo, "Pasta con Gamberetti", 16.0);
			list.add(k1); list.add(k2); list.add(k3); list.add(k4);
			double result=testApp.getOrderPrice(list);
    		assertEquals(106.875, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20PrimiTotalPriceMoreThan100Euro_BillDiscountedOf5Percent()// 0 * >100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		for(int i=0;i<3;i++) {
    			MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 15.0);
    			MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 14.5);
    			MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 17.5);
    			MenuItem k4=new MenuItem(MenuItem.itemType.Primo, "Pasta con Gamberetti", 16.0);
    			list.add(k1); list.add(k2); list.add(k3); list.add(k4);
    		}			
			double result=testApp.getOrderPrice(list);
    		assertEquals(179.55, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }

    @Test
    public void SumOfPrice_LessThan20PrimiTotalPriceLessThan100Euro_BillDiscountedOf5Percent()// 0 * <100
    {
    	try{
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		MenuItem k1=new MenuItem(MenuItem.itemType.Primo, "Pasta", 15.0);
    		MenuItem k2=new MenuItem(MenuItem.itemType.Primo, "Spaghetti", 14.5);
    		MenuItem k3=new MenuItem(MenuItem.itemType.Primo, "Lasagne", 17.5);
    		MenuItem k4=new MenuItem(MenuItem.itemType.Primo, "Pasta con Gamberetti", 16.0);
    		list.add(k1); list.add(k2); list.add(k3); list.add(k4);		
			double result=testApp.getOrderPrice(list);
    		assertEquals(63, result,0.0001);//delta 10^-4
    	}catch(RestaurantBillException e) {
    		assertEquals("Ordinazione Fallita",e.getMessage());
    	}
    }
}
