package co.edu.uptc.cellPhone.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.cellPhone.constants.CommonConstants;
import co.edu.uptc.cellPhone.dto.CellPhone;


public class ManagemenetCellPhone extends FilePlain{
	
	private List<CellPhone> listCells = new ArrayList<>();
	
	public void dumpFilePlain(String rutaArchivo) {
		List<String> records = new ArrayList<>();
		 for(CellPhone cellDTO : listCells){
			 StringBuilder contentCell = new StringBuilder();
			 contentCell.append(cellDTO.getModel()).append(CommonConstants.SEMI_COLON);
			 contentCell.append(cellDTO.getCellPhoneNumber()).append(CommonConstants.SEMI_COLON);
			 contentCell.append(cellDTO.getMemory()).append(CommonConstants.SEMI_COLON);
			 contentCell.append(cellDTO.getColor()).append(CommonConstants.SEMI_COLON);
			 records.add(contentCell.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	public void loadFilePlain( String path) {
		List<String> contentInLine = this.reader(path);
		for ( String row: contentInLine) {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()) {
				String model = tokens.nextToken();
				String cellPhoneNumber = tokens.nextToken();
				String memory = tokens.nextToken();
				String color = tokens.nextToken();
				listCells.add(new CellPhone(model, cellPhoneNumber, memory, color));
			}
		}
	}
	
	public List<CellPhone> getListCell(){
		return listCells;
	}
	public void setListCell ( List<CellPhone> listCell) {
		this.listCells = listCell;
	}
	

}
