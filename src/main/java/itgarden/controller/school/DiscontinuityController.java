/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.school;

import itgarden.model.homevisit.M_Child_info;
import itgarden.model.school.Discontinuity;
import itgarden.repository.homevisit.M_Child_infoRepository;
import itgarden.repository.school.DiscontinuityRepository;
import itgarden.repository.school.S_RegularAdmissionClassRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/discontinuity")
public class DiscontinuityController {
    
    @Autowired
    S_RegularAdmissionClassRepository s_RegularAdmissionClassRepository;
    
    @Autowired
    DiscontinuityRepository discontinuityRepository;
    
     @Autowired
    M_Child_infoRepository m_Child_infoRepository;
    
    @RequestMapping("/admissionstudentlistl")
    public String page(Model model) {
        model.addAttribute("clildlist", m_Child_infoRepository.findByRegularAdmissionClassIsNotNullAndDiscontinuityIsNull());
        return "school/admissionstudentlist";
    }
    
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("clildlist", discontinuityRepository.findAll());
        return "school/discontinuitylist";
    }
    
    @RequestMapping("/create/{id}")
    public String create(Model model, @PathVariable Long id, Discontinuity discontinuity) {
        
        M_Child_info m_Child_info = new M_Child_info();
        m_Child_info.setId(id);
        discontinuity.setChildMasterCode(m_Child_info);
         return "school/discontinuity";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Discontinuity discontinuity) {
        model.addAttribute("discontinuity", discontinuityRepository.findOne(id));
//        M_Child_info m_Child_info = new M_Child_info();
//
//        m_Child_info.setId(id);
//
//        discontinuity.setChildMasterCode(m_Child_info);
        return "school/discontinuity";
    }
    
    @RequestMapping("/save")
    public String save(Model model, @Valid Discontinuity discontinuity, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            
//        M_Child_info m_Child_info = new M_Child_info();
//
//        m_Child_info.setId(id);
//
//        discontinuity.setChildMasterCode(m_Child_info);
            return "school/discontinuity";
             }
        discontinuityRepository.save(discontinuity);
      return "redirect:/discontinuity/index";
       }
    
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Discontinuity discontinuity, RedirectAttributes redirectAttrs) {
        discontinuity = discontinuityRepository.findOne(id);
        redirectAttrs.addAttribute("id", discontinuity.getChildMasterCode().getId());
        discontinuityRepository.delete(id);
       return "redirect:/discontinuity/index";
    }
    
}
