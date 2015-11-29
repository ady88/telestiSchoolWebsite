package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class TeachersController extends AbstractSchoolController {

    @RequestMapping("/teachers")
    public String getEventsPage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return "teachers";
    }

    @Override
    protected String getPageName() {
        return "profesorii nostrii";
    }
}
