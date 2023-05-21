package com.utp.webcoulomblaw.controllers;

import com.utp.webcoulomblaw.entities.Carga;
import com.utp.webcoulomblaw.entities.FuerzaDosCargas;
import com.utp.webcoulomblaw.entities.FuerzaTresCargas;
import com.utp.webcoulomblaw.entities.RequestCarga;
import com.utp.webcoulomblaw.entities.RequestCargaTri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * WebController
 */
@Controller
public class WebController {

    @GetMapping(value = "/")
    public String index(Model model) {
        
        model.addAttribute("message", "Thank you for visiting.");

        
        return "form";
    }

    @GetMapping(value = "/trescargas")
    public String trescargas(Model model) {
        
        model.addAttribute("message", "Thank you for visiting.");

        
        return "form2";
    }
    @RequestMapping(value = "/response")
    public String response(RequestCarga r, Model model) {
        

        Carga q1 = r.getCarga1();
        Carga q2 = r.getCarga2();
        FuerzaDosCargas F = new FuerzaDosCargas(q1, q2);
        model.addAttribute("result", F.mostrarDesarrollo());

        
        return "response";
    }
    
    @RequestMapping(value = "/responsetri")
    public String responsetri(RequestCargaTri r, Model model) {
        

        Carga q1 = r.getCarga1();
        Carga q2 = r.getCarga2();
        Carga q3=r.getCarga3();
        FuerzaTresCargas F = new FuerzaTresCargas(q1, q2,q3);
        model.addAttribute("resulttri", F.mostrarDesarrolloTri());

        
        return "responsetri";
    }
}
