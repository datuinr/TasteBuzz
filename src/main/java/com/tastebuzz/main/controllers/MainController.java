package com.tastebuzz.main.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tastebuzz.main.models.Recipe;
import com.tastebuzz.main.models.User;
import com.tastebuzz.main.services.RecipeService;
import com.tastebuzz.main.services.UserService;
import com.tastebuzz.main.validators.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
    private final UserValidator userValidator;
    private final RecipeService recipeService;
 
    public MainController(UserService userService, UserValidator userValidator, RecipeService recipeService) {
    	this.userValidator = userValidator;
        this.userService = userService;
        this.recipeService = recipeService;
        
    }
    
    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("recipe") Recipe recipe, HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userId");
    	if (id != null) {
    		Long userId = (Long) session.getAttribute("userId");
    		User current = userService.findUserById(userId);
    		model.addAttribute("user", current);
    		List<Recipe> recipes = recipeService.findAll();
    		model.addAttribute("recipes", recipes);
    		return "index.jsp";
    	}
		List<Recipe> recipes = recipeService.findAll();
		model.addAttribute("recipes", recipes);
    	return "index.jsp";
    }
    
    @GetMapping("/register")
    public String register(@ModelAttribute("user") User user) {
    	return "register.jsp";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, 
    						   BindingResult result, 
    						   HttpSession session,
    						   Model model
    						   ) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "register.jsp";
    	}
    	User newUser = userService.registerUser(user);
    	session.setAttribute("userId", newUser.getId());
    	return "redirect:/dashboard";
    	
    }
    
    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
    	return "login.jsp";
    }
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user,
    						@RequestParam("email") String email, 
    						@RequestParam("password") String password, 
    						Model model, 
    						HttpSession session, RedirectAttributes flash
    						) {
    	if(userService.authenticateUser(email, password)) {
    		User thisUser = userService.findByEmail(email);
    	  	model.addAttribute("user", thisUser);
    		session.setAttribute("userId", thisUser.getId());
    		return "redirect:/dashboard";
    	}
    	model.addAttribute("error", "login failed, please try again");
    	return "login.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    

    //recipe controller
    @GetMapping("/dashboard")
    public String dashboard(@ModelAttribute("user") User user, @ModelAttribute("recipe") Recipe recipe, HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	User u = userService.findUserById((Long) session.getAttribute("userId"));
    	model.addAttribute("user",u);
    	List<Recipe> recipes = recipeService.findAll();
    	model.addAttribute("recipes", recipes);
    	return "dashboard.jsp";
    }

    
    @GetMapping("/add-recipe")
    public String addRecipePage(@ModelAttribute("recipeObj") Recipe recipe, HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	User u = userService.findUserById((Long) session.getAttribute("userId"));
    	model.addAttribute("user",u);
    	return "recipe.jsp";
    }
    
    @PostMapping("/add-recipe")
    public String addRecipe(@Valid @ModelAttribute("recipeObj") Recipe recipe, BindingResult result, HttpSession session, Model model) {
    	if(result.hasErrors()) {
    		User u = userService.findUserById((Long) session.getAttribute("userId"));
        	model.addAttribute("user",u);
        	return "recipe.jsp";
	    }
	    User u = userService.findUserById((Long) session.getAttribute("userId"));
	    recipe.setCreator(u);
	    recipeService.addRecipe(recipe);
	    return "redirect:/";
    }
    
    @GetMapping("/recipes/{id}")
    public String viewPage(@PathVariable("id") Long id, Model model, HttpSession session) {
    	User u = userService.findUserById((Long) session.getAttribute("userId"));
    	model.addAttribute("user",u);
    	Recipe r = recipeService.findById(id);
    	model.addAttribute("recipe", r);
    	return "recipe-detail.jsp";
    }
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam("nor") String nor) {
    	return "redirect:/search/" + nor;
    }
    
    //renders searchByRecipe page
    @RequestMapping(value="/search/{nor}")
    public String searchByRecipe(@Valid @PathVariable("nor") String nor, Model model) {
    	List<Recipe> recipes = recipeService.findNameOfRecipe(nor);
    	model.addAttribute("recipes", recipes);
    	model.addAttribute("nor", nor);
    	return "findRecipe.jsp";
    }
    
    
    @GetMapping("/dashboard/users/{id}/edit-profile")
    public String editUserPro(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	User u = userService.findUserById(id);
    	model.addAttribute("user", u);
    	return "editUser.jsp";
    }
    
    @PutMapping("/dashboard/users/{id}/edit-profile")
    public String updateUserPro(@Valid @ModelAttribute("userObj") User user, BindingResult result) {
    	if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	userService.updateUser(user);
        	return "redirect:/dashboard";
        }
    }
}
