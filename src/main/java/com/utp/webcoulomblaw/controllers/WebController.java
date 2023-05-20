package com.utp.webcoulomblaw.controllers;

import com.utp.webcoulomblaw.entities.RequestCarga;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** WebController */
@Controller
public class WebController {
  @GetMapping(value = "/")
  public String index(Model model) {
    // add `message` attribute
    model.addAttribute("message", "Thank you for visiting.");

    // return view name
    return "form";
  }

  @RequestMapping(value = "/response")
  public String response(RequestCarga r, Model model) {
    // add `message` attribute

    double q1 = r.getQ1();
    double q2 = r.getQ2();
    double d = r.getD();

    model.addAttribute("result", q1);

    // return view name
    return "response";
  }
}
