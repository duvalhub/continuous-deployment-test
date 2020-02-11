import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.JenkinsBuild

def call(Trace trace) {
    launchBuild(trace.jenkinsBuild)
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}
