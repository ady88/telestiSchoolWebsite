package home.telestischool.repository;

import home.telestischool.model.PageNews;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author adrian
 */
public interface PageNewsRepository extends CrudRepository<PageNews, Long> {

    List<PageNews> findByNamePageAndLanguage(String namePage, String language);
}
