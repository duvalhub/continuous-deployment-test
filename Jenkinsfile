
@Library(['test-library@feature/base', 'shared-library@feature/multiple-env']) _
env.PIPELINE_BRANCH = "feature/multiple-env"

// dockerSlave() {
node() {
    properties([
        parameters([
            string(defaultValue: '1', name: 'REPETITIONS'),
        ])
    ])
    checkout scm
    
    for (int i = 0; i < params.REPETITIONS.toInteger(); i++) {
        echo "########## Running test #$i"
        runTest()
    }
}