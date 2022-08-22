package com.emit.vehicle.service.user;

import java.util.List;
import java.util.Optional;

import com.emit.vehicle.service.parameters.GlobalServiceParameters;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emit.vehicle.model.User;
import com.emit.vehicle.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository uRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.uRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return uRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = uRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("The item with the id "+id+" doesn't exists");
    }

    @Override
    public List<User> getPage(Integer pageNumber) {
        Pageable page = PageRequest.of(pageNumber, GlobalServiceParameters.SMALL_RECORDS_AMOUNT.getValue());
        return uRepository.findAll(page).getContent();
    }

    @Override
    public User save(User entity) {
        return uRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return uRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        uRepository.deleteById(id);
    }
}
