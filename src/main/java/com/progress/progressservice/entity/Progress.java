package com.progress.progressservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Progress {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int progressId;
    private Integer progressCourseId;
    private Integer progressRemDuration;
    @Column(length = 50)
    private String progressCourseStatus;
    private Integer progressNoModCompleted;
    private Integer progressNoChaCompleted;
}
