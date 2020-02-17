def call () {
    library "shared-library@${env.PIPELINE_BRANCH}"
    echo "uh"
}