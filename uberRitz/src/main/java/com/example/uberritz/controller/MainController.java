package com.example.uberritz.controller;

import com.example.uberritz.model.Plat;
import com.example.uberritz.service.PlatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class MainController {

	@Autowired
    private PlatService platService;

    @RequestMapping(value = { "/", "/accueil" }, method = RequestMethod.GET)
	public String accueil(Model model) {

		return "accueil";
	}

	@RequestMapping(value = { "/midisoir" }, method = RequestMethod.GET)
	public String midisoir(Model model) {

		return "midisoir";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = { "/queue" }, method = RequestMethod.GET)
	public String queue(Model model) {

		return "queue";
	}

	@RequestMapping(value = { "/menumidi" }, method = RequestMethod.GET)
	public String menumidi(Model model) {

		return "menumidi";
	}

	@RequestMapping(value = { "/menusoir" }, method = RequestMethod.GET)
	public String menusoir(Model model) {

		return "menusoir";
	}

    @GetMapping("/test")
    public String test(Model model) {
        Iterable<Plat> listPlat = platService.getPlats();
        model.addAttribute("plats", listPlat);

        return "test";
    }

    @GetMapping("/savePlat")
    public String greetingForm(Model model) {
        model.addAttribute("plato", new Plat());
        return "savePlat";
    }

    @PostMapping("/savePlat")
    public String greetingSubmit(@ModelAttribute Plat plat, Model model) {
        model.addAttribute("plato", plat);
        return "savePlat";
    }
	
}
