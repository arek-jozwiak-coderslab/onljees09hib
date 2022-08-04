package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String source) {
        return categoryRepository.findById(Long.parseLong(source)).orElse(null);

//        Optional<Category> byId = categoryRepository.findById(Long.parseLong(source));
//        if (!byId.isEmpty()) {
//            return byId.get();
//        }
//        return null;
    }
}
