package jdbc;

public class Emp {
	private int i;
	private String string;
	private String string2;
	private int j;
	private String string3;
	private int k; //Sal
	private int l;
	private int m; //Deptno
	
	public Emp(int i, String string, String string2, int j, String string3, int k, int l, int m) {
		this.i = i;
		this.string = string;
		this.string2 = string2;
		this.j = j;
		this.string3 = string3;
		this.k = k;
		this.l = l;
		this.m = m;
	}

	public int getDeptno() {
		return m;
	}

	public int getSal() {
		return k;
	}

}