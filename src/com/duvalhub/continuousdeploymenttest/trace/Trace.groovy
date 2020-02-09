package com.duvalhub.continuousdeploymenttest.trace

class Trace {
    String git_url
    String place_holder = "####"
    String uuid
    String file_to_edit = "src/index.html"
    String url

    Trace(String uuid) {
        this.uuid = uuid
    }

    String getStringToSearch() {
        return String.format("%s", this.uuid)
    }

    String getGitUrl(String username, String password ) {
        return String.format("https://%s:%s@github.com/duvalhub/continuous-deployment-test-app.git", username, password)
    }

    String getGitUrl( ) {
        return "git@github.com:duvalhub/continuous-deployment-test-app.git"
    }
}