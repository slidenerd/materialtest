package materialtest.vivz.slidenerd.services;

import materialtest.vivz.slidenerd.logging.L;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;

/**
 * Created by Windows on 23-02-2015.
 */
public class MyService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        L.t(this,"onStartJob");
        jobFinished(jobParameters, false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
