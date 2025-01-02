package com.progress.progressservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progress.progressservice.dto.requestDto.ProgressRequestDto;
import com.progress.progressservice.dto.responseDto.ProgressResponseDto;
import com.progress.progressservice.service.ProgressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/progres")
@Tag(name = "Progress API", description = "API for managing progres")
public class ProgressController {

	@Autowired
	private ProgressService progresService;

	@GetMapping
	@Operation(summary = "Fetch all progress", description = "Retrieve a list of all progres")
	public List<ProgressResponseDto> getAllProgresss() throws Exception {
		log.info("Entered into getAllProgresss");
		return progresService.getAllProgresss();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Fetch a progres", description = "Retrieve a progres by passing its ID")
	public ResponseEntity<ProgressResponseDto> getProgressById(@PathVariable Integer id) throws Exception {
		log.info("Entered into getProgressById");
		Optional<ProgressResponseDto> progres = progresService.getProgressById(id);
		return progres.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Persist progres", description = "Persist progres data")
	public ResponseEntity<ProgressResponseDto> createProgress(@RequestBody ProgressRequestDto progresReqDto) throws Exception {
		log.info("Entered into createProgress");
		ProgressResponseDto resDto = progresService.createProgress(progresReqDto);
		return ResponseEntity.ok(resDto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update progres", description = "Update a progres by passing its ID")
	public ResponseEntity<ProgressResponseDto> updateProgress(@PathVariable Integer id,
			@RequestBody ProgressRequestDto progresReqDto) throws Exception {
		log.info("Entered into updateProgress");
		ProgressResponseDto resDto = progresService.updateProgress(id, progresReqDto);
		return ResponseEntity.ok(resDto);
	}

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete progres", description = "Delete a progres by passing its ID")
    public ResponseEntity<Boolean> deleteProgress(@PathVariable Integer id) throws Exception {
    	log.info("Entered into deleteProgress");
		return ResponseEntity.ok(progresService.deleteProgress(id));
    }
}