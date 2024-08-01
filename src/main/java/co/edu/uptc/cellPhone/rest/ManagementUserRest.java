package co.edu.uptc.cellPhone.rest;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.uptc.cellPhone.dto.User;
import co.edu.uptc.cellPhone.persistence.ManagementUser;

@Path("/ManagementUser")
public class ManagementUserRest {

public static ManagementUser managementUsers = new ManagementUser();
	
	static {
		managementUsers.loadFilePlain("/data/user.txt");
	}
	
	/*@GET
	@Path("/getUsers")
	@Produces( { MediaType.APPLICATION_JSON } )
	public List<User> getUsers(){
		return managementUsers.getListUsers();
	}*/
	
	@GET
	@Path("/getUsersByCode")
	@Produces( { MediaType.APPLICATION_JSON } )
	public User getUsersByCode(@QueryParam("User") String nameUser) {
		for (User users : managementUsers.getListUsers()) {
			if (users.getUser().equals(nameUser)) {
				return users;
			}
		}
		return null;
	}
	
	@POST
	@Path("/createUser")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public User createUser(User userDTO) {
		for (User user : managementUsers.getListUsers()) {
	        if (user.getUser().equalsIgnoreCase(userDTO.getUser())) {
	            return null;
	        }
	    }
	    if (managementUsers.getListUsers().add(userDTO)) {
	        managementUsers.dumpFilePlain("user.txt");
	        return userDTO;
	    }
	    return null;
	}
	
	@DELETE
	@Path("/deleteUser")
	@Produces({ MediaType.APPLICATION_JSON })
	public User deleteUser(@QueryParam("User") String nameUser) {
		User userDTO = this.getUsersByCode(nameUser);
		if(userDTO != null) {
			managementUsers.getListUsers().remove(userDTO);
			managementUsers.dumpFilePlain("user.txt");
		}
		return userDTO;
	}
	
}
