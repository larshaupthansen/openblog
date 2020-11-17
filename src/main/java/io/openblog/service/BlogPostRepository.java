package io.openblog.service;

import java.util.Optional;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

import io.openblog.model.BlogPost;

@Repository
public interface BlogPostRepository extends CosmosRepository<BlogPost, String> {

    Optional<BlogPost> findByUri(String uri);
}