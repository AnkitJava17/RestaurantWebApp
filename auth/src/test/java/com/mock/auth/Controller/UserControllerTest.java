// package com.mock.auth.Controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.mock.auth.controller.UserController;
// import com.mock.auth.feignConfig.Consumer;
// import com.mock.auth.model.User;

// class UserControllerTest {

//     @Mock
//     private Consumer consumer;

//     @InjectMocks
//     private UserController userController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testRegisterUser() {
//         User user = new User();
//         user.setEmail("john@example.com");
//         user.setUsername("JohnDoe");
//         user.setPassword("password");
//         user.setAccount("somethingAC");
//         user.setMobile("7088152293");        when(consumer.registerUser(any(User.class))).thenReturn(user);

//         ResponseEntity<?> response = userController.registerUser(user);

//         assertEquals(HttpStatus.CREATED, response.getStatusCode());
//         assertEquals(user, response.getBody());
//     }

//     @Test
//     void testRegisterUser_UserAlreadyExists() {
//         User user = new User();
//         user.setEmail("ankit@gmail.com");
//         user.setUsername("Ankit");
//         user.setPassword("password");
//         user.setAccount("somethingAC");
//         user.setMobile("7088152293");       
//         when(consumer.registerUser(any(User.class))).thenReturn(null);

//         ResponseEntity<?> response = userController.registerUser(user);

//         assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
//         assertEquals("user already exists", response.getBody());
//     }

//     @Test
//     void testGetAllUsers() {
//         List<User> users = new ArrayList<>();
//         users.add(new User("ank@gmail.com","Ank", "password","182392813","uttarakhand", "ac112321"));
//         users.add(new User("bnk@yahoo.com","Bnk", "pa2sword","112392813","uttarakhand", "a21234221"));
        
//         when(consumer.getAllUsers()).thenReturn(users);

//         ResponseEntity<List<User>> response = userController.getAllUsers();

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(users, response.getBody());
//     }

//     @Test
//     void testGetUser() {
//         User user = new User("ankit@gmail.com","ankit", "pa2sword","112392813","uttarakhand", "a21234221");

//         when(consumer.getUserByName("ankit")).thenReturn(user);

//         ResponseEntity<?> response = userController.getUser("ankit");

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(user, response.getBody());
//     }

//     @Test
//     void testGetUser_UserNotFound() {
//         when(consumer.getUserByName("ankit")).thenReturn(null);

//         ResponseEntity<?> response = userController.getUser("ankit");

//         assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//         assertEquals("user not found", response.getBody());
//     }
// }