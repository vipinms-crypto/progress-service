package com.progress.progressservice.mapper;

import org.mapstruct.Mapper;

import com.progress.progressservice.dto.requestDto.ProgressRequestDto;
import com.progress.progressservice.dto.responseDto.ProgressResponseDto;
import com.progress.progressservice.entity.Progress;

@Mapper(componentModel = "spring")
public interface ProgressMapper {
    Progress toEntity(ProgressRequestDto reqDto);
    ProgressResponseDto toDto(Progress course);
}