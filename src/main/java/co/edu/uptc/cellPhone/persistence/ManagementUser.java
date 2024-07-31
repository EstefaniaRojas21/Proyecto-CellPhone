package co.edu.uptc.cellPhone.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.cellPhone.constants.CommonConstants;
import co.edu.uptc.cellPhone.dto.User;

public class ManagementUser extends FilePlain{
	private List<User> listUsers = new ArrayList<>();

	public void dumpFilePlain(String rutaArchivo) {
		List<String> records = new ArrayList<>();
		 for(User userDTO : listUsers){
			 StringBuilder contentContact = new StringBuilder();
			 contentContact.append(userDTO.getUser()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(userDTO.getPassword()).append(CommonConstants.SEMI_COLON);
			 records.add(contentContact.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	public void loadFilePlain(String rutaNombreArchivo) {
		List<String> contentInLine = this.reader(rutaNombreArchivo);
		for(String row: contentInLine) {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String user = tokens.nextToken();
				String password = tokens.nextToken();
				listUsers.add(new User(user, password));
			}
		}
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	
}
