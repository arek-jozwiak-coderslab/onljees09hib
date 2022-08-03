package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        bookRepository.findAllByTitle("Java")
                .forEach(b -> System.out.println(b.getId()));
        System.out.println("-------");
        bookRepository.findAllByCategory(categoryRepository.getOne(1l))
                .forEach(b -> System.out.println(b.getId()));

        System.out.println("-------");
        bookRepository.findAllByCategoryId(2l)
                .forEach(b -> System.out.println(b.getId()));
        return "ok";
    }

    @GetMapping("/test-second")
    @ResponseBody
    public String testSecond() {
        bookRepository.findByAuthorsContains(authorDao.findById(1l))
                .forEach(b -> System.out.println(b.getId()));
        System.out.println("-------");
        Book firstByCategoryOrderByTitle = bookRepository.findFirstByCategoryOrderByTitle(categoryRepository.getOne(1l));
        System.out.println(firstByCategoryOrderByTitle.getId());

        System.out.println("-------");
        return "ok";
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {

        Optional<Book> byId = bookRepository.findById(1l);


        Author byId1 = authorDao.findById(1l);
        Author byId2 = authorDao.findById(2l);
        List<Author> objects = new ArrayList<>();
        objects.add(byId1);
        objects.add(byId2);

        bookRepository.save(Book.builder().
                title("Thinking in PHP")
                .description("Book fo java")
                .publisher(publisherDao.findById(1l))
                .authors(objects)
                .rating(4)
                .build());
        return "ok";
    }

    @GetMapping("/edit")
    @ResponseBody
    public String edit() {
        Book byId = bookDao.findById(1l);
        byId.setTitle("Thinking in Java");
        bookDao.update(byId);
        return "ok";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        Book byId = bookDao.findById(1l);
        System.out.println(byId);
        return "ok";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        Book byId = bookDao.findById(1l);
        bookDao.delete(byId);
        return "ok";
    }
}
