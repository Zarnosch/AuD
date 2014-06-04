package Blatt_09;

public class Food {
	private String name_;
	private String generic_term_;
	private int average_weight_;
	
	public Food(String generic_term){
		generic_term_ = generic_term;
		name_ = generic_term;
		average_weight_ = 9000;
	}
	
	public Food(String generic_term, String name, int average_weight){
		generic_term_ = generic_term;
		name_ = name;
		average_weight_ = average_weight;
	}

   public int hashCode() {
	   return Math.abs(name_.hashCode() + generic_term_.hashCode() + average_weight_);
   }
   
   public String toString() {
	   String foed ="";
	   foed += "Typ: " + generic_term_ + ", Name: " + name_ +" Gewicht: " + average_weight_;
	   return foed;
   }
}