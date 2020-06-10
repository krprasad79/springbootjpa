package com.example.springbootjpa.controller;

import com.example.springbootjpa.dao.AlienRepo;
import com.example.springbootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("home")
    public String home(){
        return "home.jsp";
    }
    /*@RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }*/
    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid){
           Alien  a = repo.getOne(aid);
           repo.delete(a);
           return "Deleted";
    }
    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

    @PutMapping("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

   /* @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //System.out.println(repo.findByTech("java"));
        //System.out.println(repo.findByAidGreaterThan(102));
        //System.out.println(repo.findByTechSorted("java"));
        mv.addObject(alien);
        return mv;
    } */

   /* @RequestMapping("/aliens")
    @ResponseBody
    public String getAliens(){
        return repo.findAll().toString();
    }*/

    //@RequestMapping(path = "/aliens",produces = {"application/xml"})
    //@RequestMapping(path = "/aliens")
    @GetMapping(path = "/aliens")
    //@ResponseBody
    public List<Alien> getAliens(){
        return repo.findAll();
    }

    /*@RequestMapping("/alien/{aid}")
    @ResponseBody
    public String getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid).toString();
    }*/

    @RequestMapping("/alien/{aid}")
    //@ResponseBody
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }
}

