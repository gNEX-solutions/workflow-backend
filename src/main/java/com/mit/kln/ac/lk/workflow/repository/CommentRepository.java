package com.mit.kln.ac.lk.workflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mit.kln.ac.lk.workflow.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {


	List<Comment> findAllByEvent(String id);

}
