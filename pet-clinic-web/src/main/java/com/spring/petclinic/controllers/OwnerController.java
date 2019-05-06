package com.spring.petclinic.controllers;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String listOwners(Model model) {
//
//        model.addAttribute("owners", ownerService.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping({"/find", "/find.html"})
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {

        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.finadAllByLastNameLike("%"+owner.getLastName()+"%");
        if(owners.isEmpty()) {
            //no owners found
            result.rejectValue("LastName", "notFound", "not found");
            return "owners/findOwners";
        } else if(owners.size() == 1) {
            owner = owners.iterator().next();
            return "redirect:/owners/"+owner.getId();
        } else {
            model.addAttribute("selections", owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", this.ownerService.findById(new Long(ownerId)));
        return mav;
    }
}
