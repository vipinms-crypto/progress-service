package com.progress.progressservice.service;

import java.util.List;
import java.util.Optional;

import com.progress.progressservice.dto.requestDto.ProgressRequestDto;
import com.progress.progressservice.dto.responseDto.ProgressResponseDto;

public interface ProgressService {

	 // Create a new progress
    ProgressResponseDto createProgress(ProgressRequestDto progressRequestDto) throws Exception;

    // Get all progresss
    List<ProgressResponseDto> getAllProgresss() throws Exception;

    // Get a progress by ID
    Optional<ProgressResponseDto> getProgressById(Integer id) throws Exception;

    // Update a progress
    ProgressResponseDto updateProgress(Integer id, ProgressRequestDto progressRequestDto) throws Exception;

    // Delete a progress
    boolean deleteProgress(Integer id) throws Exception;
}
