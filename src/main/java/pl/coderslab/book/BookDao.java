package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.dog.Dog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }
}
