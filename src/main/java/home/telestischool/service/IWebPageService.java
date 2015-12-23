package home.telestischool.service;

import home.telestischool.model.PageInfo;
import home.telestischool.model.PageNews;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IWebPageService {
    
    void refreshData();
    List<PageInfo> getPageInfos();
    List<PageNews> getPageNews(String pageName);
    void addPageNews(PageNews pageNews);
}