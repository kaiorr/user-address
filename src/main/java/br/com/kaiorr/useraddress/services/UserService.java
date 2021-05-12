package br.com.kaiorr.useraddress.services;

import br.com.kaiorr.useraddress.dto.AddressDTO;
import br.com.kaiorr.useraddress.dto.UserDTO;
import br.com.kaiorr.useraddress.entities.Address;
import br.com.kaiorr.useraddress.entities.User;
import br.com.kaiorr.useraddress.repositories.AddressRepository;
import br.com.kaiorr.useraddress.repositories.UserRepository;
import br.com.kaiorr.useraddress.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public List<UserDTO> findAll() {
        List<User> list = userRepository.findAll();

        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public UserDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserDTO dtoUser) {
        User entity = new User();

        dtoToEntity(dtoUser, entity);
        entity = userRepository.save(entity);

        return new UserDTO(entity,entity.getAddresses());
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User entity = userRepository.getOne(id);
            dtoToEntity(dto, entity);
            entity= userRepository.save(entity);
            return  new UserDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found! " +id);
        }
    }

    private void dtoToEntity(UserDTO dtoUser, User entity) {
        entity.setName(dtoUser.getName());
        entity.setEmail(dtoUser.getEmail());
        entity.setCpf(dtoUser.getCpf());
        entity.setBirthDate(dtoUser.getBirthDate());

        entity.getAddresses().clear();

        for (AddressDTO addDTO: dtoUser.getAddress()) {
            Address address = addressRepository.getOne(addDTO.getId());
            entity.getAddresses().add(address);
        }
    }
}
