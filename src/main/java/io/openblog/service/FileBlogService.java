package io.openblog.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.ObjectMapper;


import io.openblog.model.BlogPost;

/**
 * Note: This implementation is hopelessly inefficient - It is solely made so I
 * cound concentrate on other aspects of the solution. Do not use this for
 * *anything* but testing
 */

public class FileBlogService implements IBlogService {

    private static final String BASEFOLDER = "/home/haupt/openblog/";

    public BlogPost get(int id) throws IOException {

        String fileName = BASEFOLDER + id + ".json";
        return readPageFromFile(fileName);
    }


    public BlogPost get(String uri) throws IOException {

        var list = searchFiles ( (BlogPost p) -> p.getUri().equals(uri));
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public List<BlogPost> getAll() throws IOException {
        return searchFiles ( (BlogPost p) -> true);
    }

    private BlogPost readPageFromFile(String fileName) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        return jsonToPage(json);
    }

    private BlogPost jsonToPage(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, BlogPost.class);   
    }
    
    /**
     * Totally inefficient - do not use in production
     * @param selector
     * @return
     * @throws IOException
     */
    private List<BlogPost> searchFiles(Predicate<BlogPost> selector) throws IOException {
        File folder = new File(BASEFOLDER);
        List<BlogPost> posts = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            BlogPost page = readPageFromFile(fileEntry.getAbsolutePath());
            
            if(selector.test(page)) {
                posts.add(page);
            }   
        }
        return posts;
    }

}
