package io.openblog.model;

import java.util.Date;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "posts", ru = "400")
public class BlogPost {
    
    private String id;

    private String uri;
    private String title;

    private Date createDate;

    private String content;
    

    public String getId()  { return id; }
    public void setId(String id) { this.id = id; }


    public String getUri() { return this.uri; }
    public void setUri(String uri) { this.uri = uri; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public Date getDate() { return this.createDate;}
    public void setDate(Date date) { this.createDate = date;}
    
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }

}
