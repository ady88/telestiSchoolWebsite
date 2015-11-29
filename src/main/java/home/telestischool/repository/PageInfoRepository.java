package home.telestischool.repository;

import home.telestischool.model.PageInfo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author adrian
 */
public interface PageInfoRepository extends CrudRepository<PageInfo, Long> {

    List<PageInfo> findByNameAndLanguage(String name, String language);

    List<PageInfo> findByLanguage(String language);
}
