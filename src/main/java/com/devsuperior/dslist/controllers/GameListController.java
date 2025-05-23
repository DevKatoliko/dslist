package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping("/lists")
public class GameListController {
	@Autowired
	GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll(){
		var response = gameListService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{id}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable(name = "id") Long id){
		var response = gameService.findByList(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/{listId}/replacement")
	public ResponseEntity<Void> move(@PathVariable(name = "listId") Long listId,@RequestBody ReplacementDTO body){
		gameListService.move(listId, body.sourceIndex(), body.destinationIndex());
		return ResponseEntity.noContent().build();
	}
}
