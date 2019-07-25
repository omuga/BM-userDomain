package com.tps.user.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.tps.user.models.BookItem;

import org.springframework.lang.NonNull;

import java.util.Set;

import javax.persistence.*;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "USER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")    
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(max = 100)
    @Column(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull    
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "user_books",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "bookitem_id") })
    private Set<BookItem> books = new HashSet<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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

    public void setBooks(Set<BookItem> books){
        this.books = books;
    }

    public Set<BookItem> getBooks(){
        return this.books;
    }

}