package com.progress.progressservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.progress.progressservice.dto.requestDto.ProgressRequestDto;
import com.progress.progressservice.dto.responseDto.ProgressResponseDto;
import com.progress.progressservice.entity.Progress;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProgressMapper {
    Progress toEntity(ProgressRequestDto reqDto);
    ProgressResponseDto toDto(Progress course);
	void updateProgressFromDto(ProgressRequestDto reqDto, @MappingTarget Progress user);

}