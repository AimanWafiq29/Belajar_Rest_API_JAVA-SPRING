package programmerzamannowrestfull.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.ContactResponse;
import programmerzamannowrestfull.model.CreateContactRequest;
import programmerzamannowrestfull.model.SearchContactRequest;
import programmerzamannowrestfull.model.UpdateContactRequest;

@Service
public interface ContactService {

    ContactResponse create(User user, CreateContactRequest request);

    ContactResponse get(User user, String id);

    ContactResponse update(User user, UpdateContactRequest request);
    
    void delete(User user, String contactid);
    
    Page<ContactResponse> search(User user, SearchContactRequest request);

}
