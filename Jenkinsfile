@Library(['test-library@master', 'shared-library@feature/builder-version']) _
env.PIPELINE_BRANCH = "feature/builder-version"

// dockerSlave() {
node() {
    properties([
        parameters([
            string(defaultValue: '1', name: 'REPETITIONS'),
//            string(defaultValue: 'master', name: 'PIPELINE_VERSION')
        ])
    ])
//    library "test-library@${env.BRANCH_NAME}"
//    library "shared-library@${params.PIPELINE_VERSION}"
//    env.PIPELINE_BRANCH = params.PIPELINE_VERSION

    checkout scm

    int max_repetion = params.REPETITIONS.toInteger()
    for (int i = 1; i <= max_repetion; i++) {
        echo "########## Running test #$i/$max_repetion"
        runTest()
    }

    echo "All $max_repetion Tests are successful!"
}