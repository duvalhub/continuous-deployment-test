import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    modifyGitRepo(trace)
    launchBuild(trace)
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}