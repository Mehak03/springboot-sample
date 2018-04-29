package com.spring.hibernate.SpringMVCHibernateProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.SpringMVCHibernateProject.model.ApplicanJSONResponse;
import com.spring.hibernate.SpringMVCHibernateProject.model.Applicant;
import com.spring.hibernate.SpringMVCHibernateProject.service.ApplicantService;

@Controller
public class ApplicantController {
	
	@Autowired
	private ApplicantService appService;
	
	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addApplicant(@ModelAttribute(value="applicant") Applicant user, ModelMap model)
    {
		System.out.println("user:::" + user + "user name: " + user.getName());
		int transId = appService.addApplicant(user);
		model.addAttribute("applicantname", user.getName());
		model.addAttribute("id", transId);
        return "hello";
    }*/
	
	@RequestMapping(value = "/api/add", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ApplicanJSONResponse addApplicant(@ModelAttribute Applicant user)
    {
		ApplicanJSONResponse response = new ApplicanJSONResponse();
		System.out.println("user:::" + user + "user name: " + user.getName());
		int transId = appService.addApplicant(user);
		user.setId(transId);
		response.setApplicant(user);
        return response;
    }
	
	@RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("BankApplicationForm", "applicant", new Applicant());
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployee(@ModelAttribute(value="applicant") Applicant user, ModelMap model)
    {
		List<Applicant> applicantList = appService.getApplicants();
		model.addAttribute("applicantList",applicantList);
        return "RegisteredApplicants";
    }
	
	@RequestMapping(value = "/api/update", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ApplicanJSONResponse updateApplicantDetails(@ModelAttribute(value="applicant") Applicant user)
    {
		ApplicanJSONResponse response = new ApplicanJSONResponse();
		System.out.println("user:::" + user + "user name: " + user.getName()+"user id: " + user.getId());
		appService.updateApplicantDetails(user);
		response.setApplicant(user);
        return response;
    }
	
	/*@RequestMapping(value = "/api/update", method = RequestMethod.GET)
    public String updateApplicantDetails(@ModelAttribute(value="applicant") Applicant user, ModelMap model)
    {
		List<Applicant> applicantList = appService.getApplicants();
		if(applicantList.get(0).getId() == 1){
			user.setName("Mehak Arora");
			user.setId(applicantList.get(0).getId());
			user.setAge(29);
			user.setGender("Female");
			user.setVisaStatus("PR");
			user.setCountry("Australia");
		}
		System.out.println("user:::" + user + "user name: " + user.getName());
		appService.updateApplicantDetails(user);
		model.addAttribute("applicantname", user.getName());
        return "hello";
    }*/
}
