
//@Library(['test-library@feature/base', 'shared-library@feature/multiple-env']) _
//env.PIPELINE_BRANCH = "feature/multiple-env"

// dockerSlave() {
node() {
    properties([
        parameters([
            string(defaultValue: '1', name: 'REPETITIONS'),
            string(defaultValue: 'master', name: 'PIPELINE_VERSION')
        ])
    ])
    echo "Branch name is : ${env.BRANCH_NAME}"
    library "test-library@${env.BRANCH_NAME}"
    library "shared-library@${params.PIPELINE_VERSION}"
    env.PIPELINE_BRANCH = params.PIPELINE_VERSION
    sh "exit 0"
    return
    checkout scm

    int max_repetion = params.REPETITIONS.toInteger()
    for (int i = 1; i <= max_repetion; i++) {
        echo "########## Running test #$i/$max_repetion"
        runTest()
    }

    echo "All $max_repetion Tests are successful!"
}