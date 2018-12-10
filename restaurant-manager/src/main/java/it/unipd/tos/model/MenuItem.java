////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
private enum itemType{
Pizza, Primo
}
public itemType type;
private String name;
private double price;
public MenuItem(itemType tipo, String nome, double prezzo) {
this.type=tipo;
this.name=nome;
if(prezzo>0) {
this.price=prezzo;
}else {
this.price=0.0;
}
}
public int getType() {
if(type==itemType.Pizza)
{
	return 0;
}else
{
	return 1;
}
}
public String getName() {
return name;
}
public double getPrice() {
return price;
}
}
