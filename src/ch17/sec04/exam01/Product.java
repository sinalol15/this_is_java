package ch17.sec04.exam01;

import java.util.Objects;

public class Product {
	private int pno;
	private String name;
	private String company;
	private int price;
	
	public Product(int pno, String name, String company, int price) {
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pno == other.pno;
	}

	public int getPno() { return pno; }
	public String getName() { return name; }
	public String getCompany() { return company; }
	public int getPrice() { return price; }
	
	@Override
	public String toString() {
		return new StringBuilder() //문자열 버퍼라 그냥 toString으로 처리하는 것보단 조금 더 빠르고 효과적이다.
				.append("{")
				.append("pno:" + pno + ", ")
				.append("name:" + name + ", ")
				.append("company:" + company + ", ")
				.append("price:" + price)
				.append("}")
				.toString();
	}
}