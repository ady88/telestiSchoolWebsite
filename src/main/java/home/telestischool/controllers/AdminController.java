package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class AdminController extends AbstractSchoolController {

    private static final String ADMIN_PAGE_NAME = "admin";
    
    @RequestMapping("/admin")
    public String getHistoryPage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return ADMIN_PAGE_NAME;
    }

    @Override
    protected String getPageName() {
        return ADMIN_PAGE_NAME;
    }

}
