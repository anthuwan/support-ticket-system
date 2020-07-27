package com.support.ticket.system.controller;

import com.support.ticket.system.model.TicketDetailsVo;
import com.support.ticket.system.stub.TicketDetailsStub;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SupportSysHomeController {
    @RequestMapping("/ticket-support-system")
    public String viewHomePage(Model model) {
        List ticketDetailsList = TicketDetailsStub.list();
        model.addAttribute("ticketDetailsList", ticketDetailsList);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        TicketDetailsVo ticketDetails = new TicketDetailsVo();
        model.addAttribute("ticketDetails", ticketDetails);

        return "new-ticket";
    }

    @PostMapping(value = "/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public String addProduct(@Valid @ModelAttribute("ticketDetails") TicketDetailsVo ticketDetailsVo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new-ticket";
        } else {
            TicketDetailsStub.create(ticketDetailsVo);
            return "redirect:/ticket-support-system";
        }

    }

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveProduct(@Valid @ModelAttribute("ticketDetails") TicketDetailsVo ticketDetailsVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-ticket";
        } else {
            TicketDetailsStub.update(ticketDetailsVo.getId(), ticketDetailsVo);
            return "redirect:/ticket-support-system";
        }
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit-ticket");
        TicketDetailsVo ticketDetails = TicketDetailsStub.get((long) id);
        mav.addObject("ticketDetails", ticketDetails);

        return mav;
    }

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String get() {

        return "hi";
    }


}
