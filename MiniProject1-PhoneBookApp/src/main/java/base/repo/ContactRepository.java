package base.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.ContactDetailsEntity;

public interface ContactRepository extends JpaRepository<ContactDetailsEntity, Serializable>{

}
