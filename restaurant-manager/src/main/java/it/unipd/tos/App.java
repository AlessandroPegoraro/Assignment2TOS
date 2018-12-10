////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

public class App implements RestaurantBill
{
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException
    {
	if(itemsOrdered.size()>20)
        {
             throw new RestaurantBillException("Numero di Ordinazioni maggiore di 20 Elementi");
        }
        int sumPizze=0;
	double minPrice=-1.0;
	for(int i:itemsOrdered.size())
        {
        	if(itemsOrdered.get(i).getType()==0)
            	{
                	sumPizze++;
			if(itemsOrdered.get(i).getPrice()<minPrice || minPrice<0.0)
                        {
				minPrice=itemsOrdered.get(i).getPrice;
                        }
		}
        }
	double totalPrice=0.0;
        for(int i:itemsOrdered.size())
        {
		if(sumPizze>10 && itemsOrdered.get(i).getType()==0)
		{
			if(itemsOrdered.get(i).getPrice()!=minPrice)
			{
				totalPrice+=itemsOrdered.get(i).getPrice();
			}
		}else
		{
			totalPrice+=itemsOrdered.get(i).getPrice();
		}
	}
	if(totalPrice>100.0)
	{
		totalPrice*=0.95;
	}
	return totalPrice;
    }
}
