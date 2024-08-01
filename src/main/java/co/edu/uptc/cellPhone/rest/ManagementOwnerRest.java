package co.edu.uptc.cellPhone.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.uptc.cellPhone.dto.CellPhone;
import co.edu.uptc.cellPhone.dto.OwnerCellPhone;
import co.edu.uptc.cellPhone.persistence.ManagemenetCellPhone;
import co.edu.uptc.cellPhone.persistence.ManagementOwner;

@Path("/ManagementOwnerCellPhone")
public class ManagementOwnerRest {
	
	public static ManagementOwner managementOwners = new ManagementOwner();
	public static ManagemenetCellPhone managementCells = new ManagemenetCellPhone();
	
	static {
		managementOwners.loadFilePlain("/data/owner.txt");
		managementCells.loadFilePlain("/data/cellPhone.txt");
	}
	
	@GET
	@Path("/getOwners")
	@Produces( {MediaType.APPLICATION_JSON} )
	public List<OwnerCellPhone> getOwners(){
		return managementOwners.getListOwners();
	}
	
	@GET
	@Path("/getOwnerByCode")
	@Produces ( {MediaType.APPLICATION_JSON} )
	public OwnerCellPhone getOwnerByCode(@QueryParam("code") String code) {
		for(OwnerCellPhone ownerDTO: managementOwners.getListOwners()) {
			if(ownerDTO.getDocument().equals(code)) {
				return ownerDTO;
			}
		}
		return null;
	}
	
	@POST
	@Path("/createOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public OwnerCellPhone createOwner(OwnerCellPhone owner) {
	    if (!managementCells.getListCell().contains(owner.getCell())) {
	        return null;
	    }
	    for (OwnerCellPhone existingOwner : managementOwners.getListOwners()) {
	        if (existingOwner.getCell().equals(owner.getCell())) {
	        	return null;
	        }
	    }
	    if (managementOwners.getListOwners().add(owner)) {
	        managementOwners.dumpFilePlain("owner.txt");
	        return owner;
	    }
		return null;
	}
	
	@PUT
	@Path("/updateOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public OwnerCellPhone updateOwner(OwnerCellPhone ownerDTO) {
		for(OwnerCellPhone owner: managementOwners.getListOwners()) {
			if(owner.getDocument().equals(ownerDTO.getDocument())) {
				owner.setName(ownerDTO.getName());
				owner.setLastName(ownerDTO.getLastName());
				owner.setDocument(ownerDTO.getDocument());
				owner.setCountry(ownerDTO.getCountry());
				owner.setAge(ownerDTO.getAge());
				owner.setCell(ownerDTO.getCell());
				managementOwners.dumpFilePlain("owner.txt");
				return owner;
			}
		}
		return null;
	}
	
	@DELETE
	@Path("/deleteOwner")
	@Produces({ MediaType.APPLICATION_JSON })
	public OwnerCellPhone deleteOwner(@QueryParam("code") String code) {
		OwnerCellPhone owner = this.getOwnerByCode(code);
		
		if(owner != null) {
			managementOwners.getListOwners().remove(owner);
			managementOwners.dumpFilePlain("owner.txt");
			return owner;
		}
		return null;
	}
	

}
