/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javasaw.database.DatabaseMySQL;
import javasaw.model.User;

/**
 *
 * @author afgha
 */
public class UsersDAOMySQL implements UsersDAO{
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_UPDATED_AT = "updated_at";

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = DatabaseMySQL.connectDB();
             Statement stmt = connection.createStatement()) {

            String query = "SELECT * FROM " + TABLE_NAME;
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(COLUMN_ID));
                user.setUsername(rs.getString(COLUMN_USERNAME));
                user.setPassword(rs.getString(COLUMN_PASSWORD));
                user.setCreatedAt(rs.getTimestamp(COLUMN_CREATED_AT).toLocalDateTime());
                user.setUpdatedAt(rs.getTimestamp(COLUMN_UPDATED_AT).toLocalDateTime());
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> getUserByUsername(String username) {
        List<User> userList = new ArrayList<>();

        try (Connection connection = DatabaseMySQL.connectDB();
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USERNAME + " = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(COLUMN_ID));
                user.setUsername(rs.getString(COLUMN_USERNAME));
                user.setPassword(rs.getString(COLUMN_PASSWORD));
                user.setCreatedAt(rs.getTimestamp(COLUMN_CREATED_AT).toLocalDateTime());
                user.setUpdatedAt(rs.getTimestamp(COLUMN_UPDATED_AT).toLocalDateTime());
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void insertUser(User user) {
        try (Connection connection = DatabaseMySQL.connectDB();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO " + TABLE_NAME + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ") VALUES (?, ?)")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = DatabaseMySQL.connectDB();
             PreparedStatement stmt = connection.prepareStatement(
                     "UPDATE " + TABLE_NAME + " SET " + COLUMN_USERNAME + " = ?, " + COLUMN_PASSWORD +
                             " = ? WHERE " + COLUMN_ID + " = ?")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = DatabaseMySQL.connectDB();
             PreparedStatement stmt = connection.prepareStatement(
                     "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?")) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean isValid(User user) {
    if (user.getUsername() == null || user.getUsername().isEmpty()) {
        return false;
    }

    if (user.getPassword() == null || user.getPassword().isEmpty()) {
        return false;
    }

    try (Connection connection = DatabaseMySQL.connectDB()) {
        String query = "SELECT COUNT(*) FROM "+TABLE_NAME+" WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            if (count > 0) {
                return true; // Username dan password valid
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // Username atau password tidak valid
}
}
