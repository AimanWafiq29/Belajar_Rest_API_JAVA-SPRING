package programmerzamannowrestfull.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.AddressResponse;
import programmerzamannowrestfull.model.CreateAddressRequest;
import programmerzamannowrestfull.model.UpdateAddressRequest;
import programmerzamannowrestfull.model.WebResponse;
import programmerzamannowrestfull.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService sddressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses"
    )
    public WebResponse<AddressResponse> create(
            User user,
            @RequestBody CreateAddressRequest request,
            @PathVariable("contactId") String contactid
    ) {
        request.setContactId(contactid);
        AddressResponse addressResponse = sddressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> get(
            User user,
            @PathVariable("contactId") String contactid,
            @PathVariable("addressId") String addressId
    ) {
        AddressResponse addressResponse = sddressService.get(user, contactid, addressId);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }

    @PutMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> update(
            User user,
            @RequestBody UpdateAddressRequest request,
            @PathVariable("contactId") String contactId,
            @PathVariable("addressId") String addressId
    ) {

        request.setContactId(contactId);
        request.setAddressId(addressId);

        AddressResponse addressResponse = sddressService.update(user, request);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }

    @DeleteMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> remove(
            User user,
            @PathVariable("contactId") String contactId,
            @PathVariable("addressId") String addressId
    ) {
        sddressService.remove(user, contactId, addressId);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<AddressResponse>> list(
            User user,
            @PathVariable("contactId") String contactId
    ) {
        List<AddressResponse> addressResponses = sddressService.list(user, contactId);
        return WebResponse.<List<AddressResponse>>builder().data(addressResponses).build();
    }
}
