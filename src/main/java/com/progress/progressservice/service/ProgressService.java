package com.progress.progressservice.service;

import java.util.List;
import java.util.Optional;

import com.progress.progressservice.dto.requestdto.ProgressRequestDto;
import com.progress.progressservice.dto.responsedto.ProgressResponseDto;
import com.progress.progressservice.exception.ServiceLayerException;

public interface ProgressService {

	 // Create a new progress
    ProgressResponseDto createProgress(ProgressRequestDto progressRequestDto) throws ServiceLayerException;

    // Get all progresss
    List<ProgressResponseDto> getAllProgresss() throws ServiceLayerException;

    // Get a progress by ID
    Optional<ProgressResponseDto> getProgressById(Integer id) throws ServiceLayerException;

    // Update a progress
    ProgressResponseDto updateProgress(Integer id, ProgressRequestDto progressRequestDto) throws ServiceLayerException;

    // Delete a progress
    boolean deleteProgress(Integer id) throws ServiceLayerException;
}
