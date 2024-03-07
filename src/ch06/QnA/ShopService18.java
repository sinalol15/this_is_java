package ch06.QnA;

public class ShopService18 {
	private static ShopService18 singleton = new ShopService18();
	
	private ShopService18() {}
	
	static ShopService18 getInstance() {
		return singleton;
	}
}