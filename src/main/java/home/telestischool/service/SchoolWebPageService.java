package home.telestischool.service;

import home.telestischool.model.PageInfo;
import home.telestischool.model.PageNews;
import home.telestischool.repository.PageInfoRepository;
import home.telestischool.repository.PageNewsRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Stores information regarding the school web site pages and the content of the
 * pages.
 *
 * @author adrian
 */
@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SchoolWebPageService {

    private static final Logger LOG = Logger.getLogger(SchoolWebPageService.class.getName());

    private static final String DEFAULT_LANGUAGE = "ro";

    @Autowired
    private PageInfoRepository pageInfoRepository;

    @Autowired
    private PageNewsRepository pageNewsRepository;

    private List<PageInfo> pageInformations;

    private Map<String, List<PageNews>> pageNewsMap;

    @PostConstruct
    public void init() {
        pageInformations = pageInfoRepository.findByLanguage(DEFAULT_LANGUAGE);
        pageNewsMap = new HashMap<>();
        for (PageInfo pageInfo : pageInformations) {
            final String pageName = pageInfo.getName();
            List<PageNews> items = pageNewsRepository.findByNamePageAndLanguage(pageName, DEFAULT_LANGUAGE);
            pageNewsMap.put(pageName, items);
        }
    }

    public List<PageInfo> getPageInfos() {
        return pageInformations;
    }

    public List<PageNews> getPageNews(String pageName) {
        if (pageName == null) {
            LOG.severe("The pageName is null.");
            return new ArrayList();
        }
        return pageNewsMap.get(pageName);
    }
}
