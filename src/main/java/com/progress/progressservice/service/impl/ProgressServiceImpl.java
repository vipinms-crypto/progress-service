package com.progress.progressservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.progressservice.dto.requestDto.ProgressRequestDto;
import com.progress.progressservice.dto.responseDto.ProgressResponseDto;
import com.progress.progressservice.entity.Progress;
import com.progress.progressservice.exception.ResourceNotFoundException;
import com.progress.progressservice.mapper.ProgressMapper;
import com.progress.progressservice.repository.ProgressRepository;
import com.progress.progressservice.service.ProgressService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProgressServiceImpl implements ProgressService {
	
	@Autowired
    private ProgressRepository progressRepository;
	
	@Autowired
	private ProgressMapper progressMapper;

    @Override
    public ProgressResponseDto createProgress(ProgressRequestDto progressRequestDto) throws Exception {
    	log.info("Entered into service method createProgress");
        Progress progress = progressMapper.toEntity(progressRequestDto);
        Progress savedProgress = progressRepository.save(progress);
        log.info("Exit from service method createProgress");
        return mapToResponseDto(savedProgress);
    }

    @Override
    public List<ProgressResponseDto> getAllProgresss() throws Exception{
    	log.info("Entered into service method getAllProgresss");
        return progressRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProgressResponseDto> getProgressById(Integer id) throws Exception{
    	log.info("Entered into service method getProgressById");
        return progressRepository.findById(id)
                .map(this::mapToResponseDto);
    }

    @Override
    public ProgressResponseDto updateProgress(Integer id, ProgressRequestDto progressRequestDto) throws Exception{
    	log.info("Entered into service method updateProgress");
        Optional<Progress> progressOptional = progressRepository.findById(id);
        if (progressOptional.isPresent()) {
            Progress progress = progressOptional.get();
            progress = progressMapper.toEntity(progressRequestDto);
            Progress updatedProgress = progressRepository.save(progress);
            log.info("Exit from service method updateProgress with response ,"+ updatedProgress);
            return  progressMapper.toDto(updatedProgress);
        } else {
        	log.info("No Progress data found for given id,"+id);
        	throw new ResourceNotFoundException("No data found");
        }
    }

    @Override
    public boolean deleteProgress(Integer id) throws Exception{
    	log.info("Entered into service method deleteProgress");
        if (progressRepository.existsById(id)) {
            progressRepository.deleteById(id);
            log.info("Entered into service method deleteProgress");
            return true;
        } else {
        	log.info("No Progress data found for given id,"+id);
        	throw new ResourceNotFoundException("No data found");
        }
    }

    private ProgressResponseDto mapToResponseDto(Progress progress) {
    	log.info("Entered into service method mapToResponseDto");
    	return progressMapper.toDto(progress);
    }
}
