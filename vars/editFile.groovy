import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.BASE_DIR}/scripts/editFile/editFile.sh"
    withEnv([
        "PLACE_HOLDER=${trace.place_holder}",
        "UUID=${trace.uuid}",
        "FILE_TO_EDIT=${trace.file_to_edit}"
    ]){
        executeScript(script)
    }
}