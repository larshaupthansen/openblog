package io.openblog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.openblog.model.BlogPost;
import io.openblog.service.IBlogService;

@Controller
public class BlogController {

    private IBlogService blogservice;

    public BlogController(IBlogService blogservice) {
        this.blogservice = blogservice;
    }

    @GetMapping("/posts/**")
    public String page(HttpServletRequest request, Model model) throws IOException {


        //TODO: Remove the /pages prefix but still service static files.
        
        var uri = request.getRequestURI().substring(6);

        BlogPost blogPost = blogservice.get(uri);

        model.addAttribute("posts", blogservice.getAll());

        model.addAttribute("post", blogPost);
		return "post";
	}



}