package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class ProjectsController extends AbstractSchoolController{

    @RequestMapping("/projects")
    public String getHomePage(Model model) {
        model.addAttribute("pageName", getPageName());
        model.addAttribute("pageNews", getPageNews());
        model.addAttribute("infos", getPageInfos());
        return "projects";
    }
    
    @Override
    protected String getPageName() {
        return "proiecte";
    }
    
}
