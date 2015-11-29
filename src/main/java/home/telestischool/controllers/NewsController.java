package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class NewsController  extends AbstractSchoolController{

    @RequestMapping("/news")
    public String getHistoryPage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return "news";
    }

    @Override
    protected String getPageName() {
        return "informatii utile";
    }
}
