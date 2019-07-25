package com.tps.user.repository;

//import org.springframework.data.repository.CrudRepository;
import com.tps.user.models.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookItemRepository extends JpaRepository<BookItem, Long> {

}