package com.spring.petclinic.controllers;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    public static final String VIEWS_OWNER_CREATE_OR_UPDATE = "owners/createOrUpdateOwnerForm";
    public static final String VIEWS_OWNER_LIST = "owners/ownersList";
    public static final String VIEWS_OWNER_REDIRECT = "redirect:/owners/";
    public static final String VIEWS_OWNER_FIND = "owners/findOwners";
    public static final String VIEWS_OWNER_DETAILS = "owners/ownerDetails";

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/find", "/find.html"})
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_FIND;
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
            return VIEWS_OWNER_FIND;
        } else if(owners.size() == 1) {
            owner = owners.iterator().next();
            return VIEWS_OWNER_REDIRECT+owner.getId();
        } else {
            model.addAttribute("selections", owners);
            return VIEWS_OWNER_LIST;
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView mav = new ModelAndView(VIEWS_OWNER_DETAILS);
        mav.addObject("owner", this.ownerService.findById(new Long(ownerId)));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return VIEWS_OWNER_REDIRECT+savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult result,
                                    @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE;
        } else {
            owner.setId(ownerId);
            ownerService.save(owner);
            return VIEWS_OWNER_REDIRECT+ownerId;
        }
    }
}
