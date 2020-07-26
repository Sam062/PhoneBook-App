package base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTCT_DTLS")
public class ContactDetailsEntity {
	@Id
	@Column(name = "CNTCT_ID")
	@SequenceGenerator(name = "CNTCT_ID_SEQ", sequenceName = "CNTCT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "CNTCT_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer contactID;

	@Column(name = "CNTCT_NM")
	private String contactName;

	@Column(name = "CNTCT_NMBR")
	private Long contactNumber;

	@Column(name = "CNTCT_EMAIL")
	private String contactEmail;


	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;


	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE",insertable = false)
	private Date updatedDate;
}
