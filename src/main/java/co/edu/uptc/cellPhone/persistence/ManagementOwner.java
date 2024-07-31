package co.edu.uptc.cellPhone.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.cellPhone.constants.CommonConstants;
import co.edu.uptc.cellPhone.dto.OwnerCellPhone;

public class ManagementOwner extends FilePlain{
	private List<OwnerCellPhone> listOwners = new ArrayList<>();
	
	public void dumpFilePlain(String rutaArchivo) {
		List<String> records = new ArrayList<>();
		 for(OwnerCellPhone OwnerDTO : listOwners){
			 StringBuilder contentContact = new StringBuilder();
			 contentContact.append(OwnerDTO.getName()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(OwnerDTO.getLastName()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(OwnerDTO.getDocument()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(OwnerDTO.getCountry()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(OwnerDTO.getAge()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(OwnerDTO.getCell()).append(CommonConstants.SEMI_COLON);
			 records.add(contentContact.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	public void loadFilePlain(String rutaNombreArchivo) {
		List<String> contentInLine = this.reader(rutaNombreArchivo);
		for(String row: contentInLine) {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String name = tokens.nextToken();
				String lastName = tokens.nextToken();
				String document = tokens.nextToken();
				String country = tokens.nextToken();
				String age = tokens.nextToken();
				String cell = tokens.nextToken();
			listOwners.add(new OwnerCellPhone(name, lastName, document, country, age, cell));
			}
		}
	}

	public List<OwnerCellPhone> getListOwners() {
		return listOwners;
	}

	public void setListOwners(List<OwnerCellPhone> listOwners) {
		this.listOwners = listOwners;
	}
	
}
