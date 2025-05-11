package com.user.users;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.user.users.controller.Usercontroller;
import com.user.users.model.User;
import com.user.users.services.UserService;

@ExtendWith(MockitoExtension.class)

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private Usercontroller userController;

    @Test
    void deveListarUsers() {
        List<User> mockUsers = Arrays.asList(
                new User(1L, "Joao", "joao@email.com"),
                new User(2L, "Maria", "maria@email.com")
        );
        when(userService.listaUser()).thenReturn(mockUsers);
        List<User> users = userController.ListaUser();
        assertEquals(2, users.size());
        verify(userService, times(1)).listaUser();
    }

    @Test
    void deveSalvarUser() {
        User user = new User(null, "Carlos", "carlos@email.com");
        User savedUser = new User(1L, "Carlos", "carlos@email.com");
        when(userService.salvarUser(user)).thenReturn(savedUser);
        ResponseEntity<User> response = userController.salvarUser(user);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(savedUser, response.getBody());
        verify(userService, times(1)).salvarUser(user);
    }
}
