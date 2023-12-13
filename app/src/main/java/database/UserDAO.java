package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import models.User;

// Data Access Object (DAO) interface for User entities
@Dao
public interface UserDAO {

    // Insert a user into the database
    @Insert
    public void insert(User user);

    // Update an existing user in the database
    @Update
    public void update(User user);

    // Delete a user from the database
    @Delete
    public void delete(User user);

    // Retrieve all users from the database
    @Query("SELECT * FROM user")
    public List<User> getUsers();

    // Retrieve a user with a specific userId from the database
    @Query("SELECT * FROM user WHERE userId = :number")
    public User getUserWithId(int number);

    // Retrieve users with a specific email from the database
    @Query("SELECT * FROM user WHERE email = :email")
    public List<User> getUserWithEmail(String email);

    // Retrieve users with a specific username from the database
    @Query("SELECT * FROM user WHERE name = :name")
    public List<User> getUserWithUsername(String name);

    // Retrieve users with a specific password from the database
    @Query("SELECT * FROM user WHERE password = :password")
    public List<User> getUserWithPassword(String password);
}
