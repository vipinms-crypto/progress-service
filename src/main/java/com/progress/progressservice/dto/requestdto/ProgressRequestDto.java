package com.progress.progressservice.dto.requestdto;

import lombok.Data;

@Data
public class ProgressRequestDto {
    private Integer progressCourseId;
    private Integer progressRemDuration;
    private String progressCourseStatus;
    private Integer progressNoModCompleted;
    private Integer progressNoChaCompleted;
}
