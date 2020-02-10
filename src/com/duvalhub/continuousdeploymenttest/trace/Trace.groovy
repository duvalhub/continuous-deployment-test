package com.duvalhub.continuousdeploymenttest.trace

import com.duvalhub.git.GitRepo

class Trace {
    GitRepo gitRepo
    String place_holder = "####"
    String uuid
    String file_to_edit = "src/index.html"
    String url
    String app_workdir

    Trace(String uuid) {
        this.uuid = uuid
    }

    String getStringToSearch() {
        return String.format("%s", this.uuid)
    }

    String getGitUrl(String username, String password ) {
        return String.format("https://%s:%s@github.com/duvalhub/continuous-deployment-test-app.git", username, password)
    }

    GitRepo getGitRepo( ) {
        return new GitRepo("duvalhub", "continuous-deployment-test-app")
    }
}