package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String getContactPage() {
        return "contact";
    }
}
