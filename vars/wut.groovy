import com.duvalhub.continuousdeploymenttest.trace.Trace
@Library('shared-library')
import com.duvalhub.appconfig.Platforms

def call () {
    library "shared-library@${env.PIPELINE_BRANCH}"
    echo "uh"
}