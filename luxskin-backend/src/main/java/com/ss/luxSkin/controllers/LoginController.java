package com.ss.luxSkin.controllers;

import com.ss.luxSkin.entities.Login;
import com.ss.luxSkin.entities.Roles;
import com.ss.luxSkin.repositories.LoginRepository;
import com.ss.luxSkin.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("login")

public class LoginController {

    private static final long ADMIN_ROLE_ID = 1;
    private static final long REGULAR_CUSTOMER_ROLE_ID = 2;

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    RolesRepository rolesRepository;

    @GetMapping("/allLogins")
    public List<Login> getAllLogins()
    {
        return loginRepository.findAll();
    }

    @PostMapping("/addLogin/save")
    public ResponseEntity<?> saveLogin(@RequestBody Login form){

        Roles customerRole = rolesRepository.findById(REGULAR_CUSTOMER_ROLE_ID).get();
        Optional<Login> login = loginRepository.findLoginByNameAndPassword(form.getName(), form.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (login.isPresent()) {
            if (form.getId() == null) {
                if (login.get().getRoles().get(0).getId() == ADMIN_ROLE_ID) {
                    response.put("login", login.get());
                    response.put("message", "Успешен вход с администраторски права!");
                } else {
                    response.put("login", login.get());
                    response.put("message", "Успешен вход като потребител!");
                }
            } else {
                if (form.getId() == ADMIN_ROLE_ID){
                    if (login.get().getRoles().get(0).getId() == ADMIN_ROLE_ID){
                        response.put("login", login.get());
                        response.put("message", "Успешен вход с администраторски права!");
                    } else {
                        response.put("message", "Отказан администраторски достъп!");
                    }
                } else {
                    if (form.getId().equals(login.get().getId())){
                        form.setRoles(List.of(customerRole));
                        response.put("login", loginRepository.save(form));
                        response.put("message", "Успешно редактиран!");
                    } else {
                        response.put("message", "Потребител с такова име и парола вече съществува!");
                    }
                }
            }
        } else {
            if (form.getId() == null) {
                form.setRoles(List.of(customerRole));
                response.put("login", loginRepository.save(form));
                response.put("message", "Успешно записан!");
            } else {
                if (form.getId() == ADMIN_ROLE_ID){
                    response.put("message", "Отказан администраторски достъп!");
                } else {
                    form.setRoles(List.of(customerRole));
                    response.put("login", loginRepository.save(form));
                    response.put("message", "Успешно редактиран!");
                }
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addLogin")
    public ResponseEntity<?> saveOrUpdate (@RequestParam(required = false) Long id,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String password){
        Login form = new Login(id, name, password);

        Roles customerRole = rolesRepository.findById(REGULAR_CUSTOMER_ROLE_ID).get();
        Optional<Login> login = loginRepository.findLoginByNameAndPassword(form.getName(), form.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (login.isPresent()) {
            if (form.getId() == null) {
                if (login.get().getRoles().get(0).getId() == ADMIN_ROLE_ID) {
                    response.put("loginId", login.get().getId());
                    response.put("message", "Успешен вход с администраторски права!");
                } else {
                    response.put("loginId", login.get().getId());
                    response.put("message", "Успешен вход като потребител!");
                }
            } else {
                if (form.getId() == ADMIN_ROLE_ID){
                    if (login.get().getRoles().get(0).getId() == ADMIN_ROLE_ID){
                        response.put("loginId", login.get().getId());
                        response.put("message", "Успешен вход с администраторски права!");
                    } else {
                        response.put("message", "Отказан администраторски достъп!");
                    }
                } else {
                    if (form.getId().equals(login.get().getId())){
                        form.setRoles(List.of(customerRole));
                        response.put("loginId", loginRepository.save(form).getId());
                        response.put("message", "Успешно редактиран!");
                    } else {
                        response.put("message", "Потребител с такова име и парола вече съществува!");
                    }
                }
            }
        } else {
            if (form.getId() == null) {
                form.setRoles(List.of(customerRole));
                response.put("login", loginRepository.save(form).getId());
                response.put("message", "Успешно записан!");
            } else {
                if (form.getId() == ADMIN_ROLE_ID){
                    response.put("message", "Отказан администраторски достъп!");
                } else {
                    form.setRoles(List.of(customerRole));
                    response.put("login", loginRepository.save(form).getId());
                    response.put("message", "Успешно редактиран!");
                }
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity getId(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return ResponseEntity.ok().body("Не сте въвели име");
        }
        Optional<Login> result = loginRepository.findLoginByName(name.toLowerCase());
        return result.isPresent()?ResponseEntity.ok(result.get()) : ResponseEntity.ok("Няма намерена поръчка!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLogin(@RequestParam Long id) {

        if(!loginRepository.existsById(id))
        {
            return ResponseEntity.ok("Няма такъв продукт!");
        }

        loginRepository.deleteById(id);
        return ResponseEntity.ok("Изтрит успешно!");
    }
}
