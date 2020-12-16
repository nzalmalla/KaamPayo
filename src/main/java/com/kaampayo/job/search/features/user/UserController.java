package com.kaampayo.job.search.features.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    private JobService jobService;


    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<JobResource> listJobResource = jobService.listAll(keyword);
        model.addAttribute("listJob", listJobResource);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewJobForm(Model model) {
        JobResource jobresource = new JobResource();
        model.addAttribute("jobresource", jobresource);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveJobResource(@ModelAttribute("jobresource") JobResource jobresource) {
        jobService.save(jobresource);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditJobResourceForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_jobresource");

        JobResource jobresource = jobService.get(id);
        mav.addObject("jobresource", jobresource);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteJobResource(@PathVariable(name = "id") Long id) {
        jobService.delete(id);
        return "redirect:/";
    }


    @GetMapping("/user")
    private List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @PostMapping("/user")
    private int saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.getId();
    }
}