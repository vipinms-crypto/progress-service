package com.progress.progressservice.dto.requestDto;

import lombok.Data;

@Data
public class ProgressRequestDto {
	private int progressId;
    private Integer progressCourseId;
    private Integer progressRemDuration;
    private String progressCourseStatus;
    private Integer progressNoModCompleted;
    private Integer progressNoChaCompleted;
}
