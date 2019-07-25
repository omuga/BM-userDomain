package com.tps.user.models;

import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tps.user.models.User;
import org.hibernate.annotations.NaturalId;

import java.util.Set;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "bookitems")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")    
public class BookItem {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @NaturalId
    private String isbn;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "books")
    private Set<User> users = new HashSet<>();

    public BookItem(){

    }

    public BookItem(String isbn){
        this.isbn = isbn;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setISBN( String isbn){
        this.isbn = isbn;
    }

    public String getISBN(){
        return isbn;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }

    public Set<User> getUsers(){
        return users;
    }

}

