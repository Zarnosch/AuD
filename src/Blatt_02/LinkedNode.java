package Blatt_02;


public class LinkedNode<T> {
	private T data_ = null;
	private LinkedNode<T> next_ = null;

	// TODO: constructors
	// TODO: getters and setters
	public LinkedNode(T data, LinkedNode<T> next){
		data_ = data;
		next_ = next;
	}
	public LinkedNode(){
		this.data_ = null; 
		this.next_ = null; 
	}
	public LinkedNode(T data_) { 
		this(); 
		this.data_ = data_; 
	}

	String toText() {        
		String text = data_.toString(); 
		if (next_ == null) 
			return text + "\n"; 
		else
			return text + " -> " + next_.toText(); 
	} 




	public T getData(){
		return data_;
	}
	public LinkedNode<T> getNext(){
		return next_;
	}
	public void setData(T data){
		data_ = data;
	}
	public void setNext(LinkedNode<T> next){
		next_ = next;
	}
	public static void main(String[] args) {

		// TODO: Test
		LinkedNode<String> Montag = new LinkedNode<String>("Today is Monday");
		LinkedNode<String> Dienstag = new LinkedNode<String>("Today is Tuesday");
		LinkedNode<String> Mittwoch = new LinkedNode<String>("Today is Wednesday");
		LinkedNode<String> Donnerstag = new LinkedNode<String>("Today is Thursday");
		LinkedNode<String> Freitag = new LinkedNode<String>("Today is Friday");
		LinkedNode<String> Samstag = new LinkedNode<String>();
		LinkedNode<String> Sonntag = new LinkedNode<String>();

		String Monday = "Today is Monday";
		String Tuesday = "Today is Tuesday";
		String Wednesday = "Today is Wednesday";
		String Thursday = "Today is Thursday";
		String Friday = "Today is Friday";
		
		Montag.setNext(Dienstag);
		Dienstag.setNext(Mittwoch);
		Mittwoch.setNext(Donnerstag);
		Donnerstag.setNext(Freitag);
		
		String woche = Montag.toText();
		System.out.println(woche);


	}
}