import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.LaunchBuild

def call(Trace trace) {
    modifyGitRepo(trace)
    launchBuild(new LaunchBuild(trace.jenkins_build))
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}
