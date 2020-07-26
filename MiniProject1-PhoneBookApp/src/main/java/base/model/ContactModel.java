package base.model;

import java.util.Date;

import lombok.Data;

@Data
public class ContactModel {
	private Integer contactID;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
