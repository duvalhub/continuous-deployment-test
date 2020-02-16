
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
    int max_repetion = params.REPETITIONS.toInteger()
    for (int i = 0; i < max_repetion; i++) {
        echo "########## Running test #$i/$max_repetion"
        runTest()
    }
}