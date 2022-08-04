package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long id);

    @Query("select b from Book b where b.title= ?1")
    List<Book> findBooksByTitle(String title);

    @Query("select b from Book b where b.category = ?1")
    List<Book> findBooksByCategory(Category category);


    @Query("select b from Book b where b.publisher = ?1")
    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(int rating);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findAllBooksBetweenRating(int min, int max);

    @Query("select b from Book b where b.category=?1 order by b.title")
    Book findBookByCategoryOrderByTitle(Category category);

    Book findFirstByCategoryOrderByTitle(Category category);

    List<Book> findByAuthorsContains(Author author);
}
