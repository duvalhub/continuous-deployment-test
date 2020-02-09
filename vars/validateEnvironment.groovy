
def call(Trace trace) {
    testDevelopmentEnvironment.stage(trace)
    launchBuild(trace)
    checkState(trace)
}

def stage(Trace trace) {
    stage("Validate Environment X") {
        validateEnvironment(trace)
    }
}