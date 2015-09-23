package edu.sjsu.cmpe275.lab2;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
	
	private UserServiceImpl userSer;
	  
	  @Autowired
	  public ApplicationController(UserServiceImpl userSer){
		  
		  this.userSer = userSer;
		  System.out.println("in ApplicationController init: " + userSer.getHashmap().size());
	  }
	
	  //This method is used to create the blank HTML form for user to enter information
	 @RequestMapping(value = "/homepage", method = RequestMethod.GET)
	  public ModelAndView getBlankProfile(){
		 
		   ModelAndView model = new ModelAndView("HomePage");
		   model.addObject("homepage", new HomePage());
		   return model;		  
	  }
	 
	 //This Method create the users using post method 
	 @RequestMapping(value = "/homepage", method = RequestMethod.POST)
	  public ModelAndView createProfile(@ModelAttribute("homepage1") HomePage homepage1 ){
		 
		   System.out.println("before add: " + userSer.getHashmap().size());
		   ModelAndView model = new ModelAndView("CreateUser");
		   
		   userSer.storeUser(homepage1);
		   
		   System.out.println("after added: " + userSer.getHashmap().size());
		  
		   return model;		  
	  }
	 
	 
	 //This method uses get method return JSON object on homepage
	 @RequestMapping(value = "/homepage/{id}", method = RequestMethod.GET)
	 public ModelAndView getHomepage(@PathVariable("id") String id, @RequestParam(value="brief" , defaultValue = "false") String brief){
		 String message;
		 ModelAndView model = new ModelAndView("JSONhomepage");
		 HomePage home = userSer.getUser(id);
		 
		 if(home==null)
	       {
	    	   
	    	   return new ModelAndView("error404", "userId", id);
	       }	
			//sending JSon data withing Html pre tag
		 
		 if(brief.equals("true"))
		 {
			ObjectMapper obk = new ObjectMapper();
			try {
				message = "<br><div align='center'> <pre>"
						+ obk.writer().withDefaultPrettyPrinter().writeValueAsString(home)
						+"<pre>";
						
				model.addObject("message", message );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 else  if(brief == null || brief.equals("") || brief.equals("false"))
			 {
			 
			  model = new ModelAndView("UpdateUser");
			   

			    //model.addObject("home",home);
				   model.addObject("id",home.getId());
				   model.addObject("firstname",home.getFirstname());
				   model.addObject("lastname", home.getLastname());
				   model.addObject("email", home.getEmail());
				   model.addObject("address",home.getAddress());
				   model.addObject("organization",home.getOrganization());
				   model.addObject("aboutMyself",home.getAboutMyself());
			 }
				   
			
			return model;
	 }
	 
	 //This Method updates the homepage field using query parameters
	 @RequestMapping(value = "/homepage/{id}",method = RequestMethod.POST,params="update")
	 public ModelAndView updateUser(@ModelAttribute("homepage1") HomePage homepg,  @PathVariable("id") String id,@RequestParam(value = "firstname", required = false, defaultValue = "testFname") String fname,
	            @RequestParam(value = "lastname", required = false, defaultValue = "false") String lastname,
	            @RequestParam(value = "email", required = false, defaultValue = "false") String email,
	            @RequestParam(value = "address", required = false, defaultValue = "false") String address,
	            @RequestParam(value = "organization", required = false, defaultValue = "false") String ogranization,
	            @RequestParam(value = "aboutMyself", required = false, defaultValue = "false") String aboutMyself)
	 {
		  System.out.println("before add: " + userSer.getHashmap().size());
		   ModelAndView model = new ModelAndView("CreateUser");
		   
		   userSer.updateUser(homepg);
		   
		   System.out.println("after added: " + userSer.getHashmap().size());
		  
		   return model;	
	 }
	 
	 //This method deletes the user based on id mentioned in URL 
	 @RequestMapping(value = "/homepage/{id}",method = RequestMethod.POST,params="delete")
	 public String deleteUser(@ModelAttribute("homepage1") HomePage homepg,  @PathVariable("id") String id, Model model)
	 {
		  System.out.println("before add: " + userSer.getHashmap().size());
		  //ModelAndView model = new ModelAndView("CreateUser");
		  HomePage home = userSer.getUser(id);
		  if(home==null)
	       {
	    	   model.addAttribute("userId",id);
	    	   return "error404";
	       }
		  
		   
		   userSer.deleteUser(homepg);
		   
		   System.out.println("after deletion: " + userSer.getHashmap().toString());
		  
		   return "redirect:/homepage";
	 }
	 
	 
	 

}
