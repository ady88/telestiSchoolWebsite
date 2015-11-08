package home.telestischool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author adrian
 */
@Controller
public class EventsController {

    @RequestMapping("/events")
    public String getEventsPage() {
        return "events";
    }
}
