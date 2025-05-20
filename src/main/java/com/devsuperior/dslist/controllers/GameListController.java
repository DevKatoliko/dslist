package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

@RestController
@RequestMapping("/lists")
public class GameListController {
	@Autowired
	GameListService gameListService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll(){
		var response = gameListService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
