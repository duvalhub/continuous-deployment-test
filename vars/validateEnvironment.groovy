import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.LaunchBuild

def call(Trace trace) {
    modifyGitRepo(trace)
    LaunchBuild a = new LaunchBuild(trace.jenkins_build)
    launchBuild(a)
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}
