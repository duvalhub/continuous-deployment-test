import com.duvalhub.continuousdeploymenttest.trace.Trace
import com.duvalhub.jenkins.LaunchBuild

def call(Trace trace) {
    modifyGitRepo(trace)
    String[] names = trace.jenkins_build.split('/')
    String name = names[0]
    String job = names[1]
    String version = names[2]
    LaunchBuild a = new LaunchBuild(name, job, version)
    launchBuild(a)
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}
