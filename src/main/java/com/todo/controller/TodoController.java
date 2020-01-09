/**
 * 
 */
package com.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;
import com.todo.util.ResourceNotFoundException;

/**
 * @author Ramanuj
 *
 */
@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
	
	@Autowired
	TodoRepository repository;
	
	@GetMapping("/getAllTodos")
	public ResponseEntity<List<Todo>> getAllTodos(){
		List<Todo> todoList = repository.findAll();
		return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
		
	}
	
	@GetMapping("/getTodoById/{id}")
	public ResponseEntity<Todo> getTodoById (@PathVariable("id")long id){
		return repository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(value="/createTodo", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createTodo(@Valid @RequestBody Todo todo) {
		HttpHeaders headers = new HttpHeaders();
		repository.saveAndFlush(todo);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateTodo/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") Long todoId,
         @Valid @RequestBody Todo todoDetails) throws ResourceNotFoundException {
		Todo todo = repository.findById(todoId)
        .orElseThrow(() -> new ResourceNotFoundException("Todo Task not found for this id :: " + todoId));

		todo.setTitle(todoDetails.getTitle());
		todo.setCompleted(todoDetails.isCompleted());
        final Todo updatedTodo = repository.save(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public Map<String, Boolean> deleteTodo(@PathVariable(value = "id") Long todoId)
         throws ResourceNotFoundException {
    	Todo todo = repository.findById(todoId)
       .orElseThrow(() -> new ResourceNotFoundException("Todo Task not found for this id :: " + todoId));

        repository.delete(todo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	

}
