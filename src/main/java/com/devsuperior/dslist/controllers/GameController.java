package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> getGames(){
		var result = gameService.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> getGameById(@PathVariable(name = "id") Long id){
		var response = gameService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
