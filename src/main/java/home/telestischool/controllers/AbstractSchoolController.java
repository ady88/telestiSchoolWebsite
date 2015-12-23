package home.telestischool.controllers;

import home.telestischool.model.PageInfo;
import home.telestischool.model.PageNews;
import home.telestischool.service.IWebPageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author adrian
 */
public abstract class AbstractSchoolController {

    @Autowired
    protected IWebPageService webPageService;

    protected abstract String getPageName();

    protected List<PageInfo> getPageInfos() {
        return webPageService.getPageInfos();
    }

    protected List<PageNews> getPageNews() {
        return webPageService.getPageNews(getPageName());
    }
}
