/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.controller.admin;

import com.heroku.web.dao.SkillDAO;
import com.heroku.web.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/admin/skills")
public class SkillsController{
    @Autowired
    private SkillDAO skillDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("skills",skillDAO.getAll());
        return "admin/skills/index";
    }
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/skills/add";
    }
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")int id,
            ModelMap map){
        map.addAttribute("skill", skillDAO.getById(id));
        return "admin/skills/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Skill")Skill skill){
        if(skill.getId()==0){
            skillDAO.insert(skill);
        }else{
            skillDAO.update(skill);
        }
        return "redirect:/admin/skills";
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id")int id){
        skillDAO.delete(id);
        return "redirect:/admin/skills";
    }
}
