@Library('shared-library')
import com.duvalhub.continuousdeploymenttest.trace.Trace

def call () {
    library "shared-library@${env.PIPELINE_BRANCH}"
    echo "uh"
}