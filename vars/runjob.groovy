def runJob(jobName, params) {
    try {
        def job = Jenkins.instance.getItem(jobName)
        if (job) {
            def build = job.scheduleBuild2(0, new ParametersAction(params))
            echo "Job $jobName was executed with parameters: $params."
        } else {
            error "Nie znaleziono joba o nazwie $jobName."
        }

    } catch (Exception ex) {
        error "An error occured #ex"
    }
}

def call(String jobName, Map params) {
    return [
        jobName: jobName,
        params: params
    ]
}