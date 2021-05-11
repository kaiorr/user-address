package br.com.kaiorr.useraddress.services;

import br.com.kaiorr.useraddress.dto.AddressDTO;
import br.com.kaiorr.useraddress.entities.Address;
import br.com.kaiorr.useraddress.repositories.AddressRepository;
import br.com.kaiorr.useraddress.services.exceptions.ArtefactNotFoundException;
import br.com.kaiorr.useraddress.services.exceptions.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public List<AddressDTO> findAll(){
        List<Address> list= addressRepository.findAll();

        return list.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Optional<Address> obj = addressRepository.findById(id);
        Address entity = obj.orElseThrow(() -> new ArtefactNotFoundException("Entity not found"));

        return new AddressDTO(entity);
    }

    @Transactional
    public AddressDTO insert(AddressDTO dto) {
        try {
            Address entity = new Address();
            dtoToEntity(dto, entity);
            entity= addressRepository.save(entity);
            return new AddressDTO(entity);
        }
        catch (ConstraintViolationException e) {
            throw new DataBaseException("Integrity Violation");
        }
    }

    private void dtoToEntity(AddressDTO dto, Address entity) {
        entity.setPlace(dto.getPlace());
        entity.setComplement(dto.getComplement());
        entity.setDistrict(dto.getDistrict());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setPostalCode(dto.getPostalCode());
    }
}
