package Model;

public class User {
	private int id;
	String tcno,name,password,type1b;
	public User(int id, String tcno, String name, String password, String type1b) {
		
		this.id = id;
		this.tcno = tcno;
		this.name = name;
		this.password = password;
		this.type1b = type1b;
	}
	
	
	public User() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTcno() {
		return tcno;
	}


	public void setTcno(String tcno) {
		this.tcno = tcno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType1b() {
		return type1b;
	}


	public void setType1b(String type1b) {
		this.type1b = type1b;
	}
	
	
}
