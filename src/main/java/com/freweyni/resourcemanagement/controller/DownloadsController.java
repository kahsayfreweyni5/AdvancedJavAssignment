package com.freweyni.resourcemanagement.controller;

import com.freweyni.resourcemanagement.model.Downloads;
import com.freweyni.resourcemanagement.model.Resources;
import com.freweyni.resourcemanagement.repository.DownloadsRepository;
import com.freweyni.resourcemanagement.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DownloadsController {

    @Autowired
    DownloadsRepository downloadsRepository;

    @Autowired
    ResourcesRepository resourcesRepository;
    @RequestMapping(value = "/downloads/new", method = RequestMethod.GET)
    public String newDownloadsForm(Model model){
        Downloads downloads=new Downloads();
        model.addAttribute("downloads", downloads);
        List<Resources> resources= resourcesRepository.findAll();
        model.addAttribute("resource",resources);
        return "downloads/new";
    }
    @RequestMapping(value = "/downloads/new", method = RequestMethod.POST)
    public String saveDownloads(Model model, Downloads downloads){
        downloadsRepository.save(downloads);
        model.addAttribute("downloads", downloads);
        return "redirect:/downloads/list";

    }
    @RequestMapping(value = "/downloads/list", method = RequestMethod.GET)
    public String findAllDownloads(Model model){

        List<Downloads> downloads= downloadsRepository.findAll();
        model.addAttribute("downloads", downloads);
        return "downloads/list";
    }
    @RequestMapping(value = "/downloads/edit/{id}", method = RequestMethod.GET)
    public String editDownloads(Model model,@PathVariable Long id){
        Downloads downloads= downloadsRepository.findById(id).orElse(null);
        model.addAttribute("downloads", downloads);
        List< Resources >resources= resourcesRepository.findAll();
        model.addAttribute("resource",resources);
        return "downloads/edit";
    }


    @RequestMapping(value = "/downloads/edit", method = RequestMethod.POST)
    public String updateDownloads(Model model,Downloads downloads){
        downloadsRepository.save(downloads);
        model.addAttribute("downloads", downloads);
        return "redirect:/downloads/list";
    }

    @RequestMapping(value = "/downloads/delete/{id}", method = RequestMethod.GET)
    public String deleteDownloads(@PathVariable Long id){
        downloadsRepository.deleteById(id);
        return "redirect:/downloads/list";
    }
}
