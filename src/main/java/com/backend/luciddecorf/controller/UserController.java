package com.backend.luciddecorf.controller;

    import com.backend.luciddecorf.model.User;
    import com.backend.luciddecorf.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/users")
    public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable long id) {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @GetMapping("/username/{username}")
        public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
            User user = userService.getUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @GetMapping("/email/{email}")
        public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
            User user = userService.getUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
            User updatedUser = userService.updateUser(id, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable long id) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }