package base.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.ContactDetailsEntity;
import base.exceptions.PhonebookAppException;
import base.model.ContactModel;
import base.repo.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public Boolean saveContact(ContactModel model) {
		boolean isSaved=false;
		try {
			ContactDetailsEntity entity=new ContactDetailsEntity();
			BeanUtils.copyProperties(model, entity);
			ContactDetailsEntity result=repo.save(entity);
			if(result!=null)
				isSaved=true;
		} catch (Exception e) {
			throw new PhonebookAppException();
		}

		return isSaved;
	}

	@Override
	public List<ContactModel> getAllContacts() {
		List<ContactDetailsEntity> list=null;
		List<ContactModel> listOfContactModel=null;
		try {
			list=repo.findAll();
			listOfContactModel=list.stream().map(entity->{
				ContactModel model=new ContactModel();
				BeanUtils.copyProperties(entity, model);
				return model;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			throw new PhonebookAppException();
		}
		return listOfContactModel;
	}

	@Override
	public ContactModel getContactByID(Integer contactID) {
		ContactModel contactModel=null;
		try {
			Optional<ContactDetailsEntity> entity=repo.findById(contactID);
			if(entity.isPresent()) {
				ContactDetailsEntity contactDetailEntity=entity.get();

				contactModel=new ContactModel();

				BeanUtils.copyProperties(contactDetailEntity, contactModel);
			}

		} catch (Exception e) {
			throw new PhonebookAppException();
		}
		return contactModel;
	}

	@Override
	public Boolean deleteContact(Integer contactID) {
		try {
			Optional<ContactDetailsEntity> op=repo.findById(contactID);
			if(op.isPresent()) {
				ContactDetailsEntity entity=op.get();
				if(entity!=null) {
					repo.delete(entity);
					return true;
				}
			}
		} catch (Exception e) {
			throw new PhonebookAppException();
		}
		return false;
	}

}
