package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {
        Person person = new Person();
        person.setLogin("arek");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("arek");
        personDetails.setLastName("jozwiak");
        personDetailsDao.save(personDetails);
        person.setPersonDetails(personDetails);
        personDao.save(person);
        return "ok";
    }


}
