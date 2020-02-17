import com.duvalhub.continuousdeploymenttest.release.Release
import com.duvalhub.jenkins.JenkinsBuild
import com.duvalhub.continuousdeploymenttest.trace.Trace

def call (Trace trace) {
    JenkinsBuild launchRelease = new JenkinsBuild("continuous-deployment-pipelines", "continuous-deployment-release", "feature%2Ffirst-draft")
    launchRelease.params = [
        "FLOW_TYPE=production"
    ]
    launchBuild(launchRelease)
}