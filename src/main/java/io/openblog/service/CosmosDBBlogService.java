package io.openblog.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openblog.model.BlogPost;


public class CosmosDBBlogService implements IBlogService {

    @Autowired
    private BlogPostRepository blogRepository = null;

    public CosmosDBBlogService() {

    }

    public CosmosDBBlogService(BlogPostRepository blogRepository) {

        this.blogRepository = blogRepository;

    }
    
    @Override
    public BlogPost get(int  id) throws IOException {
        
        var sid = String.valueOf(id);
        var post = blogRepository.findById(sid);
        if(post.isPresent()) {
            return post.get();
        }
        return null;
    }

    @Override
    public BlogPost get(String uri) throws IOException {
        var post = blogRepository.findByUri(uri);
        if(post.isPresent()) {
            return post.get();
        }
        return null;
    }
    @Override
    public Iterable<BlogPost> getAll() throws IOException {
        return blogRepository.findAll();
    }
    


}
