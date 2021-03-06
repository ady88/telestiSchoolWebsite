package home.telestischool.service;

import home.telestischool.model.PageInfo;
import home.telestischool.model.PageNews;
import home.telestischool.repository.PageInfoRepository;
import home.telestischool.repository.PageNewsRepository;
import home.telestischool.utils.WebAppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Stores information regarding the school web site pages and the content of the
 * pages.
 *
 * @author adrian
 */
@Service(value = "a")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Profile("production")
public class SchoolWebPageService implements IWebPageService {

    private static final Logger LOG = Logger.getLogger(SchoolWebPageService.class.getName());

    @Autowired
    private PageInfoRepository pageInfoRepository;

    @Autowired
    private PageNewsRepository pageNewsRepository;

    private List<PageInfo> pageInformations;

    private Map<String, List<PageNews>> pageNewsMap;

    @PostConstruct
    public void init() {
        refreshData();
    }

    @Override
    public void refreshData() {
        pageInformations = pageInfoRepository.findByLanguage(WebAppConstants.DEFAULT_LANGUAGE);
        pageNewsMap = new HashMap<>();
        for (PageInfo pageInfo : pageInformations) {
            final String pageName = pageInfo.getName();
            List<PageNews> items = pageNewsRepository.findByNamePageAndLanguage(pageName, WebAppConstants.DEFAULT_LANGUAGE);
            pageNewsMap.put(pageName, items);
        }
    }

    @Override
    public List<PageInfo> getPageInfos() {
        return pageInformations;
    }

    @Override
    public List<PageNews> getPageNews(String pageName) {
        if (pageName == null) {
            LOG.severe("The pageName is null.");
            return new ArrayList();
        }
        return pageNewsMap.get(pageName);
    }

    @Override
    public void addPageNews(PageNews pageNews) {
        pageNewsRepository.save(pageNews);
    }
}
