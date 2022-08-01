package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {
        bookDao.save(Book.builder().
                title("Thinking in PHP")
                .description("Book fo java")
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
