package com.portal.healthportal.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.healthportal.entity.Patient;

import com.portal.healthportal.entity.Record;
import com.portal.healthportal.entity.appointment;
import com.portal.healthportal.entity.medicine;
import com.portal.healthportal.service.PatientService;
import com.portal.healthportal.service.medService;


import jakarta.servlet.http.HttpSession;

import com.portal.healthportal.service.RecordService;
import com.portal.healthportal.repository.PatientRepository;
import com.portal.healthportal.repository.RecordRepository;
import com.portal.healthportal.repository.appointmentrepository;



@Controller
public class healthPortal {
	@Autowired
	private appointmentrepository appointmentRepo;
	
	
	
	 @Autowired
    private PatientService ps;
    @Autowired
    private RecordService rs;
    @Autowired
    private PatientRepository pr;
    @Autowired
    private RecordRepository rr;
    @Autowired
    private medService ms;
    private Map<String, Command> commands = new HashMap<>();

    public healthPortal() {
        commands.put("view", new ViewCommand());
    }
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("home1")
    public String home1() {
        return "home1";
    }
    @GetMapping("/Add_medicine")
    public String addmed()
    {
    	return "Add_medicine";
    }

	 @GetMapping("/load_form2")
	 public String loadform2()
	 {
		 return "home";
	 }
	



    @PostMapping("/save")
    public String savemed(@ModelAttribute medicine m)
    {
    	ms.save(m);
    	return "redirect:/viewmed";
    } 
    //////////////////////////////////////////////////
    @GetMapping("/viewmed")
    public ModelAndView medAll() {
        List<medicine> list = ms.getAllM();
        ModelAndView mm = new ModelAndView();
        mm.setViewName("viewmed");
        mm.addObject("lm", list);
        return mm;
    }
    @GetMapping("/view")
    public ModelAndView getById(@RequestParam int prescription_id, @RequestParam(required=false, defaultValue="view") String command) {
        ModelAndView m = new ModelAndView();
        if (commands.containsKey(command)) {
            commands.get(command).execute(m, prescription_id);
        } else {
            m.setViewName("error");
            m.addObject("errorMessage", "Invalid command: " + command);
        }
        return m;
    }
    private class ViewCommand implements Command {
        public void execute(ModelAndView m, int prescription_id) {
            Optional<medicine> medOptional = ms.getByMId(prescription_id);
            if (medOptional.isPresent()) {
                medicine med = medOptional.get();
                m.setViewName("view");
                m.addObject("lm", med);
            } else {
                m.setViewName("error");
                m.addObject("errorMessage", "Prescription request with id " + prescription_id + " does not exist.");
            }
        }
	
    }
    ///////////////////////
    
    @GetMapping("/viewPatient")
    public ModelAndView viewPatient(){
        List<Patient> list = ps.viewPatient();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewPatient");
        mav.addObject("patient", list);
        return mav;
    }
    
    @GetMapping("/viewRecord")
    public ModelAndView viewRecord(){
        List<Record> list = rs.viewRecord();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewRecord");
        mav.addObject("record", list);
        return mav;
    }

    
    @GetMapping("/searchPatient")
    public String searchPatient() {
        return "searchPatient"; 
    }
    @GetMapping("/searchRecord")
    public String searchRecord() {
        return "searchRecord"; 
    }
    
    
    @GetMapping("/load_form")
    public String loadform() {
        return "addPatient"; 
    }
    
    @GetMapping("/load_form1")
    public String loadform1() {
        return "addRecord"; 
    }

    @GetMapping("/edit_form/{id}")
    public String editform(@PathVariable(value="id") int id, Model m) {
        Optional<Patient> patient = pr.findById(id);
        
            Patient p = patient.get();
            m.addAttribute("patient", p);
        return "editPatient" ;// replace with the actual name of your editPatient view template
    }
    
    @GetMapping("/edit_form1/{id}")
    public String editform1(@PathVariable(value="id") int id, Model m) {
        Optional<Record> record = rr.findById(id);
        
            Record r = record.get();
            m.addAttribute("record", r);
        return "editRecord" ;// replace with the actual name of your editPatient view template
    }



    @PostMapping("/save_patient")
    public String savePatient(@ModelAttribute Patient patient, HttpSession session)
    {
    	pr.save(patient);
    	session.setAttribute("msg", "Patient added Successfully");
    	
    	return "redirect:/load_form";    
    }
    
    @PostMapping("/save_record")
    public String saveRecord(@ModelAttribute Record record, HttpSession session)
    {
    	rr.save(record);
    	session.setAttribute("msg", "Record added Successfully");
    	
    	return "redirect:/load_form1";    
    }
    
    @PostMapping("/update_patient")
    public String updatePatient(@ModelAttribute Patient patient, HttpSession session,@RequestParam("id") int id)
    {
    	pr.save(patient);
    	session.setAttribute("msg", "Patient update Successfully");
    	
    	return "redirect:/viewPatient";    
    } 
    
    @PostMapping("/update_record")
    public String updateRecord(@ModelAttribute Record record, HttpSession session,@RequestParam("id") int id)
    {
    	rr.save(record);
    	session.setAttribute("msg", "Record update Successfully");
    	
    	return "redirect:/viewRecord";    
    } 
    @PostMapping("/save_appointment")
	 public String  save_appointment(@ModelAttribute appointment appointment,HttpSession session)
	 {
		appointmentRepo.save(appointment);
		session.setAttribute("msg","appointment created Sucessfully");
		
		return "redirect:/load_form2"; 
	 }


    @GetMapping("/delete_form/{id}")
    public String deletePatient(@PathVariable(value="id") int id,HttpSession session )
    {
    	pr.deleteById(id);
    	session.setAttribute("msg", "Patient Delete Successfully");
    	return "redirect:/viewPatient";    
    } 
    
    
    @GetMapping("/delete_form1/{id}")
    public String deleteRecord(@PathVariable(value="id") int id,HttpSession session )
    {
    	rr.deleteById(id);
    	session.setAttribute("msg", "Record Delete Successfully");
    	return "redirect:/viewRecord";    
    } 
}

    
    
    
    
    
  
    
  
  

    
    
