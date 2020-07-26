package base.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.ContactDetailsEntity;

public interface ContactRepository extends JpaRepository<ContactDetailsEntity, Serializable>{
	List<ContactDetailsEntity> findByContactEmail(String email);
	List<ContactDetailsEntity> findByContactNumber(Long number);

}
