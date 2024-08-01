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

import co.edu.uptc.cellPhone.dto.CellPhone;
import co.edu.uptc.cellPhone.dto.OwnerCellPhone;
import co.edu.uptc.cellPhone.persistence.ManagemenetCellPhone;
import co.edu.uptc.cellPhone.persistence.ManagementOwner;

@Path("/ManagementCellPhone")
public class ManagementCellPhoneRest {
	
	public static ManagemenetCellPhone managementCells = new ManagemenetCellPhone();
	public static ManagementOwner managementOwners = new ManagementOwner();
	
	static {
		managementCells.loadFilePlain("/data/cellPhone.txt");
		managementOwners.loadFilePlain("/data/owner.txt");
	}
	
	/*@GET
	@Path("/getCells")
	@Produces( {MediaType.APPLICATION_JSON} )
	public List<CellPhone> getCellPhones(){
		return managementCells.getListCell();
	}*/
	
	@GET
	@Path("/getCellByCode")
	@Produces ( {MediaType.APPLICATION_JSON} )
	public CellPhone getCellByCode(@QueryParam("code") int code) {
		for(CellPhone cellDTO: managementCells.getListCell()) {
			if(cellDTO.getId() == code) {
				return cellDTO;
			}
		}
		return null;
	}
	
	@POST
	@Path("/createCell")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public CellPhone createCell(CellPhone cell) {
		for (CellPhone existingCell : managementCells.getListCell()) {
	        if (existingCell.getCellPhoneNumber().equals(cell.getCellPhoneNumber())) {
	            return null;
	        }
	    }
		if(managementCells.getListCell().add(cell)) {
			managementCells.dumpFilePlain("cell.txt");
			return cell;
		}
		return null;
	}
	
	@PUT
	@Path("/updateCell")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public CellPhone updateCell(CellPhone cellDTO) {
		for ( CellPhone cell: managementCells.getListCell()) {
			if(cell.getId() == cellDTO.getId()) {
				cell.setId(cellDTO.getId());
				cell.setModel(cellDTO.getModel());
				cell.setCellPhoneNumber(cellDTO.getCellPhoneNumber());
				cell.setMemory(cellDTO.getMemory());
				cell.setColor(cellDTO.getColor());
				managementCells.dumpFilePlain("cell.txt");
				return cell;
			}
		}
		return null;
	}
	
	/*@PUT
	@Path("/updateCellByAtribute")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public CellPhone updateCellByAtribute(CellPhone cellDTO) {
		for(CellPhone cell: managementCells.getListCell()) {
			if(cell.getId() == cellDTO.getId()) {
				if(!Objects.isNull(cellDTO.getId())) {
					cell.setId(cellDTO.getId());
				}
				if(!Objects.isNull(cellDTO.getModel())) {
					cell.setModel(cellDTO.getModel());
				}
				if(!Objects.isNull(cellDTO.getCellPhoneNumber())) {
					cell.setCellPhoneNumber(cellDTO.getCellPhoneNumber());
				}
				if(!Objects.isNull(cellDTO.getMemory())) {
					cell.setMemory(cellDTO.getMemory());
				}
				if(!Objects.isNull(cellDTO.getColor())) {
					cell.setColor(cellDTO.getColor());
				}
				managementCells.dumpFilePlain("/cell.txt");
				return cell;
			}
		}
		return null;
	}*/
	
	
	@DELETE
	@Path("/deleteCell")
	@Produces({ MediaType.APPLICATION_JSON })
	public CellPhone deleteCell(@QueryParam("code") int code) {
		 CellPhone cell = this.getCellByCode(code);
		    
		    if (cell != null) {
		        managementCells.getListCell().remove(cell);
		        managementCells.dumpFilePlain("cell.txt");

		        String cellPhoneNumber = cell.getCellPhoneNumber();
		        if (cellPhoneNumber != null) {
		            OwnerCellPhone owner = managementOwners.findOwnerByCell(cellPhoneNumber);
		            if (owner != null) {
		                managementOwners.getListOwners().remove(owner);
		                managementOwners.dumpFilePlain("owner.txt");
		            }
		        }
		    }    
		    return cell;
	}
		
}
