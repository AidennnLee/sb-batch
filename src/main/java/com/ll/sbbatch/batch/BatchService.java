package com.ll.sbbatch.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BatchService {
    private final JobLauncher jobLauncher;
    private final Job simpleJob;

    @Transactional
    public void runSimpleJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .toJobParameters();
            jobLauncher.run(simpleJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}