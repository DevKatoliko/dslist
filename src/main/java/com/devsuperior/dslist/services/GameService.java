package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		var games = gameRepository.findAll();
		return games.stream().map(g -> new GameMinDTO(g)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		var response = gameRepository.findById(id).get(); // We could throw an exception, but we didn't do because this project is intended to be a simple demonstration;
		return new GameDTO(response);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(gmp -> new GameMinDTO(gmp)).toList();
	} 

}
