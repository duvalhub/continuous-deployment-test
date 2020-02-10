import com.duvalhub.continuousdeploymenttest.release.Release
import com.duvalhub.jenkins.LaunchBuild

def call (Release release) {
    LaunchBuild launchBuild = new LaunchBuild("continuous-deployment-pipelines/continuous-deployment-release/feature%2Ffirst-draft")
    launchBuild(launchBuild)
}