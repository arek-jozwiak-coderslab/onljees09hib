package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    public BookFormController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String save(Book book) {
        bookDao.save(book);
        return "redirect:/book-form/list";
    }
}
