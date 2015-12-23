package home.telestischool.controllers;

import home.telestischool.model.PageNews;
import home.telestischool.service.IWebPageService;
import home.telestischool.utils.WebAppConstants;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author adrian
 */
@Controller
public class AdminController {

    private static final Logger LOG = Logger.getLogger(AdminController.class.getName());

    private static final String ADMIN_PAGE_NAME = "admin";

    // private PageNews homeNewsToSave = new PageNews();
    @Autowired
    protected IWebPageService webPageService;

    @RequestMapping("/admin")
    public String getHistoryPage(Model model) {
        LOG.info("Entering admin controller.");
        webPageService.refreshData();
        List<PageNews> homeNews = webPageService.getPageNews("despre noi");
        List<PageNews> teachersNews = webPageService.getPageNews("profesorii nostri");

        PageNews homeNewsToSave = new PageNews();

        homeNewsToSave.setLanguage(WebAppConstants.DEFAULT_LANGUAGE);
        model.addAttribute("homeNewsToSave", homeNewsToSave);

        model.addAttribute("homeNews", homeNews);
        model.addAttribute("teachersNews", teachersNews);
        return ADMIN_PAGE_NAME;
    }

    @RequestMapping(value = "/saveHome", method = RequestMethod.POST)
    public String saveNews(@ModelAttribute PageNews homeNewsToSave, Model model) {
        homeNewsToSave.setLanguage(WebAppConstants.DEFAULT_LANGUAGE);
        model.addAttribute("homeNewsToSave", homeNewsToSave);
        if (homeNewsToSave != null) {
            LOG.info(String.format("Headline to save is: %s.", homeNewsToSave.getHeadline()));
            LOG.info(String.format("Content to save is: %s.", homeNewsToSave.getContent()));
            homeNewsToSave.setAddDate(new Date());
            homeNewsToSave.setNamePage("despre noi");
            webPageService.addPageNews(homeNewsToSave);
        }
        return ADMIN_PAGE_NAME;
    }

}
