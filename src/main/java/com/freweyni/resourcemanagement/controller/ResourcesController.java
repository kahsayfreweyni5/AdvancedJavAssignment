package com.freweyni.resourcemanagement.controller;

import com.freweyni.resourcemanagement.model.Resources;
import com.freweyni.resourcemanagement.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ResourcesController {
    @Autowired
    ResourcesRepository resourcesRepository;

    @RequestMapping(value = "/resources/new", method = RequestMethod.GET)
    public String newResourcesForm(Model model){
        model.addAttribute("resources", new Resources());
        return "resources/new";
    }
    @RequestMapping(value = "/resources/new", method = RequestMethod.POST)
    public String saveResources(Model model, Resources resources){

        resourcesRepository.save(resources);
        model.addAttribute("resources", resources);
        return "redirect:/resources/list";

    }
    @RequestMapping(value = "/resources/list", method = RequestMethod.GET)
    public String findAllResources(Model model){
        List<Resources> resources= resourcesRepository.findAll();
        model.addAttribute("resources", resources);
        return "resources/list";
    }
    @RequestMapping(value = "/resources/edit/{id}", method = RequestMethod.GET)
    public String editResources(Model model,@PathVariable Long id){
        Resources resources= resourcesRepository.findById(id).orElse(null);
        model.addAttribute("resources", resources);
        return "resources/edit";
    }


    @RequestMapping(value = "/resources/edit", method = RequestMethod.POST)
    public String updateResources(Model model,Resources resources){
        resourcesRepository.save(resources);
        model.addAttribute("resources", resources);
        return "redirect:/resources/list";
    }

    @RequestMapping(value = "/resources/delete/{id}", method = RequestMethod.GET)
    public String deleteResources(@PathVariable Long id){
        resourcesRepository.deleteById(id);
        return "redirect:/resources/list";
    }
}
