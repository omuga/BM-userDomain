package com.tps.user.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.Set;
import javax.persistence.JoinTable;;



@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(name = "books_own",
    joinColumns = @JoinColumn(name= "user_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    Set<BookItem> ownedBooks;
    
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setBooks(Set<BookItem> bookItems){
        this.ownedBooks = bookItems;
    }

    public Set<BookItem> getBooks(){
        return this.ownedBooks;
    }

}