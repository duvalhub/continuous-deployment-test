package com.duvalhub.continuousdeploymenttest.trace

class Trace {
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

}