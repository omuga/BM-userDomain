package com.tps.user.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;



@Entity
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer isbn;
    private String bookname;

    @ManyToMany(mappedBy = "ownedBooks")
    Set<User> users;

    public void setISBN(Integer isbn){
        this.isbn = isbn;
    }
    
    public Integer getISBN(){
        return this.isbn;
    }

    public void setBookname(String bookname){
        this.bookname = bookname;
    }

    public String getBookname(){
        return this.bookname;
    }

    public void setUsers(Set<User> usuarios){
        this.users = usuarios;
    }

    public Set<User> getUsers(){
        return this.users;
    }
}

