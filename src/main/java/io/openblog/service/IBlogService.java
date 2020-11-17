package io.openblog.service;

import java.io.IOException;

import io.openblog.model.BlogPost;

public interface IBlogService {

    public BlogPost get(int id) throws IOException;


    public BlogPost get(String uri) throws IOException;

    public Iterable<BlogPost> getAll() throws IOException;

}
