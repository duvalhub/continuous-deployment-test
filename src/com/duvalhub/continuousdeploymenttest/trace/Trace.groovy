package com.duvalhub.continuousdeploymenttest.trace

class Trace {
    String place_holder = "####"
    String uuid
    String file_to_edit = "src/App.js"

    Trace(String uuid) {
        this.uuid = uuid
    }

    String getStringToSearch() {
        return String.format("%s%s%s", this.place_holder, this.uuid, this.place_holder)
    }

}