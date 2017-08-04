public class Locales {
    private String lang = "EN";
    public String super_label, button, error, log1, log2;
    public void Strings(){
        if(lang.equals("EN")){
            super_label = "Log Recorder";
            button = "Enter";
            error = "|| Error: Folder doesn't exist.";
            log1 = "|| Entry logged..";
            log2 = "|| Entry logged.";
        }
    }
}
