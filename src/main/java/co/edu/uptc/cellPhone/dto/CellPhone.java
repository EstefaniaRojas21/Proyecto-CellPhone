package co.edu.uptc.cellPhone.dto;

import java.io.Serializable;

public class CellPhone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String model;
	private String cellPhoneNumber;
	private String memory;
	private String color;
	
	public CellPhone() {
		super();
	}

	public CellPhone(String model, String cellPhoneNumber, String memory, String color) {
		super();
		this.model = model;
		this.cellPhoneNumber = cellPhoneNumber;
		this.memory = memory;
		this.color = color;
	}

	public String getModel() {
		return model;
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

	@Override
	public String toString() {
	    return "CellPhone [\n"
	            + "    model=" + model + ",\n"
	            + "    cellPhoneNumber=" + cellPhoneNumber + ",\n"
	            + "    memory=" + memory + ",\n"
	            + "    color=" + color + "\n"
	            + "]";
	}

}
