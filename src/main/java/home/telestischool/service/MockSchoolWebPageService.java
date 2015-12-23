package home.telestischool.service;

import home.telestischool.model.PageInfo;
import home.telestischool.model.PageNews;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
@Service(value = "b")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Profile("test")
public class MockSchoolWebPageService implements IWebPageService {

    private static final Logger LOG = Logger.getLogger(MockSchoolWebPageService.class.getName());

    private List<PageInfo> pageInformations;

    private Map<String, List<PageNews>> pageNewsMap;

    @PostConstruct
    public void init() {
        refreshData();
    }

    @Override
    public void refreshData() {
        createMockData();
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
        final String namePage = pageNews.getNamePage();
        if (pageNewsMap.containsKey(namePage)) {
            pageNewsMap.get(namePage).add(pageNews);
        } else {
            pageNewsMap.put(namePage, Arrays.asList(pageNews));
        }
    }

    private void createMockData() {
        pageInformations = createMockPageInfos();
        pageNewsMap = createMockPageNews();
    }

    private List<PageInfo> createMockPageInfos() {
        List<PageInfo> infos = new ArrayList<>();
        PageInfo info1 = new PageInfo(0, "despre noi", "ro", "/home");
        PageInfo info2 = new PageInfo(1, "profesorii nostri", "ro", "/teachers");
        PageInfo info3 = new PageInfo(2, "informatii utile", "ro", "/news");
        PageInfo info4 = new PageInfo(3, "contact", "ro", "/contact");
        infos.add(info1);
        infos.add(info2);
        infos.add(info3);
        infos.add(info4);
        return infos;
    }

    private Map<String, List<PageNews>> createMockPageNews() {
        Map<String, List<PageNews>> news = new HashMap<>();
        return news;
    }

}
