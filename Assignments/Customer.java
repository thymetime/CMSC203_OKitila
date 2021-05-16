
public class Customer {
	
	private String name;
	private int age;

	public Customer(String str, int i) {
		this.name = str;
		this.age = i;
	}

	public Customer(Customer c1) {
		this.name = c1.name;
		this.age = c1.age;
	}
	
	public String toString() {
		return "Customer: " + this.name + ", Age: " + this.age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
