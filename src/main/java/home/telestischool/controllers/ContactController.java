package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class ContactController extends AbstractSchoolController {

    @RequestMapping("/contact")
    public String getContactPage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return "contact";
    }

    @Override
    protected String getPageName() {
        return "contact";
    }
}
