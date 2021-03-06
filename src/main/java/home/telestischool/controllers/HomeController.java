package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class HomeController extends AbstractSchoolController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return "home";
    }

    @Override
    protected String getPageName() {
        return "despre noi";
    }
}
