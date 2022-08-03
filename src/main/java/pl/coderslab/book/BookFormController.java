package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final PublisherDao publisherDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryRepository categoryRepository;

    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao, CategoryRepository categoryRepository) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String save(Model model, @Valid Book book, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            model.addAttribute("categories", categoryRepository.findAll());
            return "book/add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        return "book/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-form/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("book", bookDao.findById(id));
        return "book/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            return "book/edit";
        }
        bookDao.update(book);
        return "redirect:/book-form/list";
    }
}
