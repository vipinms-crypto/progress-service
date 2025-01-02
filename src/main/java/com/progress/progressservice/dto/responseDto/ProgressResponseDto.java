package com.progress.progressservice.dto.responseDto;

import lombok.Data;

@Data
public class ProgressResponseDto {
	private int progressId;
    private Integer progressCourseId;
    private Integer progressRemDuration;
    private String progressCourseStatus;
    private Integer progressNoModCompleted;
    private Integer progressNoChaCompleted;
}
