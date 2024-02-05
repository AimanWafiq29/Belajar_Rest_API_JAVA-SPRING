package programmerzamannowrestfull.service;

import java.util.List;
import programmerzamannowrestfull.entity.Address;
import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.AddressResponse;
import programmerzamannowrestfull.model.CreateAddressRequest;
import programmerzamannowrestfull.model.UpdateAddressRequest;

public interface AddressService {

    AddressResponse create(User user, CreateAddressRequest request);

    AddressResponse get(User user, String contactId, String addressId);

    AddressResponse update(User user, UpdateAddressRequest request);

    void remove(User user, String contactId, String addresstId);

    List<AddressResponse> list(User user, String contactId);
}
