/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.util.List;
import javasaw.model.User;

/**
 *
 * @author afgha
 */
public interface UsersDAO {
    List<User> getAllUsers();

    List<User> getUserByUsername(String username);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
    
    boolean isValid(User user);
}
