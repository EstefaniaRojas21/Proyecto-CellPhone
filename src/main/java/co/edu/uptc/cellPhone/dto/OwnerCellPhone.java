package co.edu.uptc.cellPhone.dto;

import java.io.Serializable;

public class OwnerCellPhone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastName;
	private String document;
	private String country;
	private String age;
	private String cell;
	
	public OwnerCellPhone(String name, String lastName, String document, String country, String age, String cell) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.country = country;
		this.age = age;
		this.cell = cell;
	}
	
	public OwnerCellPhone() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	@Override
	public String toString() {
	    return "OwnerCellPhone [\n"
	            + "    name=" + name + ",\n"
	            + "    lastName=" + lastName + ",\n"
	            + "    document=" + document + ",\n"
	            + "    country=" + country + ",\n"
	            + "    age=" + age + ",\n"
	            + "    cell=" + cell + "\n"
	            + "]";
	}


}
