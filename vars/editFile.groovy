import com.duvalhub.continuousdeploymenttest.trace.Trace

def call(Trace trace) {
    String script = "${env.WORKSPACE}/scripts/editFile/editFile.sh"
    withEnv([
        "UUID=${trace.uuid}",
        "FILE_TO_EDIT=${trace.file_to_edit}"
    ]){
        executeScript(script)
    }
}