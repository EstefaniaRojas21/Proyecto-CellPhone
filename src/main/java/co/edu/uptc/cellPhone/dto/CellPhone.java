package co.edu.uptc.cellPhone.dto;

import java.io.Serializable;

public class CellPhone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String model;
	private String cellPhoneNumber;
	private String memory;
	private String color;
	
	public CellPhone() {
		super();
	}

	public CellPhone(int id, String model, String cellPhoneNumber, String memory, String color) {
		super();
		this.id = id;
		this.model = model;
		this.cellPhoneNumber = cellPhoneNumber;
		this.memory = memory;
		this.color = color;
	}

	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CellPhone [id=" + id + ", model=" + model + ", cellPhoneNumber=" + cellPhoneNumber + ", memory="
				+ memory + ", color=" + color + "]";
	}
	

	

}
