package programmerzamannowrestfull.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programmerzamannowrestfull.entity.Address;
import programmerzamannowrestfull.entity.Contact;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findAllByContact(Contact contact);
    
    Optional<Address> findFirstByContactAndId(Contact contact, String id);
    

}
